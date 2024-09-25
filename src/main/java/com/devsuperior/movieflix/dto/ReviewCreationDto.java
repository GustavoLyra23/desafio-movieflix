package com.devsuperior.movieflix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ReviewCreationDto(@NotBlank(message = "texto não pode estar vazio") String text,
                                @Positive(message = "id precisa ser positivo") Long movieId) {
}
