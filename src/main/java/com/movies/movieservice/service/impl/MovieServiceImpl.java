package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.repository.MovieRepository;
import com.movies.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Transactional
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @Transactional
    public Optional<Movie> getMovieById(String id){
        return movieRepository.findById(id);
    }
    @Transactional
    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    @Transactional
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}
