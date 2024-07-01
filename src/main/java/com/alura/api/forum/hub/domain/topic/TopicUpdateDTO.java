package com.alura.api.forum.hub.domain.topic;

public record TopicUpdateDTO(
        String title,
        String message,
        Long idAuthor,
        Long idCourse
) implements TopicDTO {
        @Override
        public String getTitle() {
                return this.title;
        }

        @Override
        public String getMessage() {
                return this.message;
        }
}