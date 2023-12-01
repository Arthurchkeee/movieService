package com.movies.movieservice.service;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.Review;
import com.movies.movieservice.model.User;

import java.util.List;

public interface ReviewService {
    void calculateRating(Movie movie);
    void saveReview(Review review);
    List<Review> findReviewsByMovie(Movie movie);
    List<Review> findReviewsByUser(User user);
}
