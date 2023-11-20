package com.movies.movieservice.service;

import com.movies.movieservice.dto.FindMovieByFilter;
import com.movies.movieservice.model.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(ObjectId id);
    void addMovie(Movie movie);
    void deleteMovie(ObjectId id);
    List<Movie> findMovieByFilter(FindMovieByFilter findMovieByFilter);
}
