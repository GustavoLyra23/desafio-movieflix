package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailsDTO> findById(@PathVariable("id") Long id) {
        var movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> findReviews(@PathVariable("id") Long id) {
        var reviews = movieService.findAllReviews(id);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping()
    public ResponseEntity<Page<MovieCardDTO>> findByGenre(@RequestParam(defaultValue = "") Long genreId, Pageable pageable) {
        var movies = movieService.findByGenre(genreId, pageable);
        return ResponseEntity.ok(movies);
    }


}
