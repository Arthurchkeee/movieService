package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.repository.MovieRepo;
import com.movies.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;
    @Transactional
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }
    @Transactional
    public Optional<Movie> getMovieById(String id){
        return movieRepo.findById(id);
    }
    @Transactional
    public void addMovie(Movie movie){
        movieRepo.save(movie);
    }

    @Transactional
    public void deleteMovie(String id) {
        movieRepo.deleteById(id);
    }
}
