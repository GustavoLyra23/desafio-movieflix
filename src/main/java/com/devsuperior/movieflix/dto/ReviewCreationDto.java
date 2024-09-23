package com.devsuperior.movieflix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ReviewCreationDto(@NotBlank String text, @Positive Long movieId) {
}
