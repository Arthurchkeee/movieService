package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.Genre;
import com.movies.movieservice.repository.GenreRepository;
import com.movies.movieservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreRepository genreRepository;
    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}
