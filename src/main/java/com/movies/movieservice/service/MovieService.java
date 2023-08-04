package com.movies.movieservice.service;

import com.movies.movieservice.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(String id);
    void addMovie(Movie movie);
    void deleteMovie(String id);
}
