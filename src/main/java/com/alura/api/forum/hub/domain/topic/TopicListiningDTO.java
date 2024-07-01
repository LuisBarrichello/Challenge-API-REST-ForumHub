package com.alura.api.forum.hub.domain.topic;

import com.alura.api.forum.hub.domain.course.CourseListingDTO;
import com.alura.api.forum.hub.domain.user.UserListingDTO;

import java.time.LocalDateTime;

public record TopicListiningDTO(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        StatusTopic statusTopic,
        UserListingDTO author,
        CourseListingDTO course
) {
    public TopicListiningDTO(Topic topic) {
        this(topic.getId(),
            topic.getTitle(),
            topic.getMessage(),
            topic.getCreationDate(),
            topic.getStatus(),
            topic.getAuthor(),
            topic.getCourse()
        );
    }
}
