package com.movies.movieservice.repository;

import com.movies.movieservice.model.Movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepositoryTest {

   /* @Autowired
    MovieRepo movieRepo;
    @Test
    public void addMovie() {
        Movie movie=new Movie("Barbie","test","2023");
        Movie savedMovie=movieRepo.save(movie);
        Assertions.assertNotNull(savedMovie);
        Assertions.assertNotNull(savedMovie.getId());
    }*/
}