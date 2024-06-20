package com.movies.movieservice.service.impl;

import com.movies.movieservice.dto.FindMovieByFilter;
import com.movies.movieservice.model.Country;
import com.movies.movieservice.model.Genre;
import com.movies.movieservice.model.Movie;
import com.movies.movieservice.repository.CountryRepository;
import com.movies.movieservice.repository.GenreRepository;
import com.movies.movieservice.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
class MovieServiceImplTest {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieServiceImpl movieService;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    CountryRepository countryRepository;

    @BeforeEach
    void setUp() throws ParseException {
        countryRepository.saveAll(new HashSet<>(Arrays.asList(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"), new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))));
        genreRepository.saveAll(new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))));
        Movie firstMovie = new Movie((ObjectId) null, "test", "test", new SimpleDateFormat("dd/MM/yyyy").parse("16/11/2023"), "2023-11-16", (Set<String>) new HashSet<>(Arrays.asList("Shibe", " Pupper")), new HashSet<>(Arrays.asList( new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), 420L, 420L, 420L, (String) null);
        Movie secondMovie = new Movie((ObjectId) null, "test", "test", new SimpleDateFormat("dd/MM/yyyy").parse("16/11/2023"), "2023-11-16", (Set<String>) new HashSet<>(Arrays.asList("Shibe", " Pupper")), new HashSet<>(Arrays.asList(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"), new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<Genre>) new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), 420L, 420L, 420L, (String) null);
        movieRepository.save(firstMovie);
        movieRepository.save(secondMovie);
    }
    @AfterEach
    void tearDown() {
        movieRepository.deleteAll();
        countryRepository.deleteAll();
        genreRepository.deleteAll();
    }



    @Test
    void getAllMovies() {
        List<Movie> movieList = movieService.getAllMovies();

        assertThat(movieService.getAllMovies().size()).isEqualTo(2);
    }

    @Test
    void getMovieById() {
        Movie movie = movieRepository.findAll().get(0);
        assertTrue(movieService.getMovieById(movie.getId()).isPresent());
    }

    @Test
    void addMovie() throws ParseException {
        Movie movie = new Movie((ObjectId) null, "test", "test", new SimpleDateFormat("dd/MM/yyyy").parse("16/11/2023"), "2023-11-16", (Set<String>) new HashSet<>(Arrays.asList("Shibe", " Pupper")), (Set<Country>) new HashSet<>(Arrays.asList(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"), new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<Genre>) new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), 420L, 420L, 420L, (String) null);
        movieService.addMovie(movie);
        assertTrue(movieRepository.findById(movie.getId()).isPresent());
        movieRepository.deleteById(movie.getId());
    }

    @Test
    void deleteMovie() throws ParseException {
        Movie movie = new Movie((ObjectId) null, "test", "test", new SimpleDateFormat("dd/MM/yyyy").parse("16/11/2023"), "2023-11-16", (Set<String>) new HashSet<>(Arrays.asList("Shibe", " Pupper")), (Set<Country>) new HashSet<>(Arrays.asList(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"), new Country(new ObjectId("655b1de04d1febe1558079df"), "Antigua & Deps"), new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<Genre>) new HashSet<>(Arrays.asList(new Genre(new ObjectId("655b189f4d1febe1558079c6"), "Action"), new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"), new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"))), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), (Set<String>) new HashSet<>(Arrays.asList("Shibe", "Pupper")), 420L, 420L, 420L, (String) null);
        movieRepository.save(movie);
        movieService.deleteMovie(movie.getId());
        assertTrue(movieRepository.findById(movie.getId()).isEmpty());
    }

    @Test
    void findMovieByFilter() throws Exception {
        List<Movie> movies=movieRepository.findAll();
        FindMovieByFilter countryFilter = new FindMovieByFilter();
        countryFilter.setCountryFilter(new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"));
        assertThat(movieService.findMovieByFilter(countryFilter).size()).isEqualTo(2);
        countryFilter.setCountryFilter(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"));
        assertThat(movieService.findMovieByFilter(countryFilter).size()).isEqualTo(1);
        FindMovieByFilter genreFilter = new FindMovieByFilter();
        genreFilter.setGenreFilter(new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"));
        assertThat(movieService.findMovieByFilter(genreFilter).size()).isEqualTo(2);
        genreFilter.setGenreFilter(new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"));
        assertThat(movieService.findMovieByFilter(genreFilter).size()).isEqualTo(1);
        FindMovieByFilter countryAndGenreFilter = new FindMovieByFilter();
        countryAndGenreFilter.setCountryFilter(new Country(new ObjectId("655b1de04d1febe1558079e2"), "Australia"));
        countryAndGenreFilter.setGenreFilter(new Genre(new ObjectId("655b189f4d1febe1558079cd"), "Sci-fi"));
        assertThat(movieService.findMovieByFilter(countryAndGenreFilter).size()).isEqualTo(2);
        countryAndGenreFilter.setCountryFilter(new Country(new ObjectId("655b1de04d1febe1558079db"), "Albania"));
        countryAndGenreFilter.setGenreFilter(new Genre(new ObjectId("655b189f4d1febe1558079cf"), "Animation"));
        assertThat(movieService.findMovieByFilter(countryAndGenreFilter).size()).isEqualTo(0);
        assertThrows(Exception.class,()-> movieService.findMovieByFilter(new FindMovieByFilter()));
    }


}