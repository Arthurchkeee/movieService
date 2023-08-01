package com.movies.movieservice.controller;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {
    @Autowired
    private MovieRepo repo;

    @PostMapping(value = "/addMovie")
    public String saveMovie(Movie movie) {
        repo.save(movie);

        return "addMovie";
    }
    @GetMapping("/addMovie")
    public String addMovie(){
        return "addMovie";
    }

    @GetMapping("/findAllMovies")
    public List<Movie> getMovies() {

        return repo.findAll();
    }
    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable String id, Model model){
        Optional<Movie> movie=repo.findById(id);
        movie.ifPresent(value -> model.addAttribute("movie", value));
        return "filmPage";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        repo.deleteById(id);

        return "Deleted Successfully";
    }
}
