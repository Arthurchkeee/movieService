package com.movies.movieservice.service;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.Review;

public interface ReviewService {
    void calculateRating(Movie movie);
    void saveReview(Review review);
}
