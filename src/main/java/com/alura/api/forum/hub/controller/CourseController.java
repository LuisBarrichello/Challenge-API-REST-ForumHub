package com.alura.api.forum.hub.controller;

import com.alura.api.forum.hub.domain.course.*;
import com.alura.api.forum.hub.domain.topic.TopicListiningDTO;
import com.alura.api.forum.hub.domain.topic.TopicUpdateDTO;
import com.alura.api.forum.hub.infra.exception.ValidationException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/courses")
@SecurityRequirement(name = "bearer-key")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @PostMapping
    @Transactional
    public ResponseEntity registerCourse(@RequestBody @Valid CourseCreationDTO courseCreationDTO, UriComponentsBuilder uriBuilder) {
        Course course = new Course(courseCreationDTO.name(), courseCreationDTO.categoryCourses());
        courseRepository.save(course);

        var uri = uriBuilder.path("/courses/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);
    }

    @GetMapping
    public ResponseEntity<Page<CourseListingDTO>> listCourses(@PageableDefault Pageable pageable) {
        var page = courseRepository.findAll(pageable).map(CourseListingDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourse(@PathVariable Long id) {
        var course = courseRepository.findById(id)
                .map(CourseListingDTO::new)
                .orElseThrow(() -> new ValidationException("Curso não encontrado"));
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateCourse(@PathVariable Long id, @RequestBody @Valid CourseUpdateDTO courseUpdateDTO) {
        var course = courseService.updateCourse(courseUpdateDTO, id);
        return ResponseEntity.ok(new CourseListingDTO(course));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
