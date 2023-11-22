package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.Genre;
import com.movies.movieservice.repository.GenreRepository;
import com.movies.movieservice.service.GenreService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
@DirtiesContext
class GenreServiceImplTest {
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    GenreService genreService;

    @BeforeEach
    void setUp() {
        genreRepository.saveAll(new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))));

    }

    @AfterEach
    void tearDown() {
        genreRepository.deleteAll();
    }

    @Test
    void findAll() {
        assertThat(genreService.findAll().size()).isEqualTo(3);
    }
}