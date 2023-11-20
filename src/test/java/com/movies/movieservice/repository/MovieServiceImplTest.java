package com.movies.movieservice.repository;

import com.movies.movieservice.model.Country;
import com.movies.movieservice.model.Genre;
import com.movies.movieservice.model.Movie;

import org.bson.types.ObjectId;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepositoryTest {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    CountryRepository countryRepository;

    @Test
    void findMoviesByCountryOrGenre() {
        movieRepository.save(new Movie((ObjectId) null, "test","test", new Date("Thu Nov 16 00:00:00 MSK 2023"), "2023-11-16", (Set<String>) new HashSet<>(Arrays.asList( "Shibe", " Pupper")), (Set<Country>) new HashSet<>(Arrays.asList(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"), new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<Genre>) new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"),new  Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), 420L, 420L, 420L, (String) null));
        System.out.println("12345");
        List<Movie> moviesByCountryOrGenre=movieRepository.findMoviesByCountryOrGenre(countryRepository.findByName("Albania").getId(),genreRepository.findByName("Action").getId());
        System.out.println("test");
        assertThat(moviesByCountryOrGenre).isNotNull();
    }

}