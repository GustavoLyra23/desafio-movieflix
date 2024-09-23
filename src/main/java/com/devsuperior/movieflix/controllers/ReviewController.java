package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.ReviewCreationDto;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MEMBER')")
    public ResponseEntity<ReviewDTO> createReview(@Valid @RequestBody ReviewCreationDto dto) {
        var review = reviewService.createReview(dto);
        URI uri = URI.create("/reviews/" + review.getId());
        return ResponseEntity.created(uri).body(review);
    }


}
