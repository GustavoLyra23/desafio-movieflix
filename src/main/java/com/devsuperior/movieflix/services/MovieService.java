package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public MovieService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    @Transactional(readOnly = true)
    public MovieDetailsDTO findById(Long id) {
        var movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        return new MovieDetailsDTO(movie);
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> findAllReviews(Long id) {
        return reviewRepository.findAllReviewsFromMovieId(id).stream().map(ReviewDTO::new).toList();
    }
}
