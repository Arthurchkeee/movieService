package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.Review;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.ReviewRepository;
import com.movies.movieservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public void calculateRating(Movie movie){
        List<Review> reviews=reviewRepository.findReviewsByMovie(movie);
        double rating= 0;
        if(!reviews.isEmpty()) {
            double sum=0;
            for (Review review : reviews) {
                sum+=review.getMark();
            }
            rating=sum/reviews.size();
        }
        movie.setRating(rating);
    }
    @Transactional
    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
    @Override
    public List<Review> findReviewsByMovie(Movie movie){
        return reviewRepository.findReviewsByMovie(movie);
    }

    @Override
    public List<Review> findReviewsByUser(User user) {
        return reviewRepository.findReviewsByUser(user);
    }
}
