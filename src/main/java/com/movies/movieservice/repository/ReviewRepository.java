package com.movies.movieservice.repository;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    List<Review> findReviewsByMovie(Movie movie);
}
