package com.alura.api.forum.hub.domain.course;

public record CourseUpdateDTO(
        String name,
        CategoryCourses categoryCourses
) {
}
