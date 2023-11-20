package com.movies.movieservice.repository;

import com.movies.movieservice.model.Country;
import com.movies.movieservice.model.Genre;
import com.movies.movieservice.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    @Query("{'country': ?0,'genre':  ?1}")
    List<Movie> findMoviesByCountryOrGenre(ObjectId country, ObjectId genre);
}
