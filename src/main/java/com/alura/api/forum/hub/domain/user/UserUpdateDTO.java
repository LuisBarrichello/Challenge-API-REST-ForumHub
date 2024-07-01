package com.alura.api.forum.hub.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(
        @NotBlank(message = "Nome não pode ser vazio")
        String name
) {
}
