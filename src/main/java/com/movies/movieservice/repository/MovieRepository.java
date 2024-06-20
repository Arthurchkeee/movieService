package com.movies.movieservice.repository;

import com.movies.movieservice.model.Country;
import com.movies.movieservice.model.Genre;
import com.movies.movieservice.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    List<Movie> findMoviesByCountryAndGenre(Country country, Genre genre);
    List<Movie> findMoviesByGenre(Genre genre);

    List<Movie> findMoviesByCountry(Country country);
}
