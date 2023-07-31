package com.movies.movieservice.controller;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class MovieController {
    @Autowired
    private MovieRepo repo;

    @PostMapping(value = "/addMovie",consumes={"application/json"})
    public String saveMovie(@RequestBody Movie movie) {
        repo.save(movie);

        return "Added Successfully";
    }
    @GetMapping("/addMovie")
    public String addMovie(){
        return "addMovie";
    }

    @GetMapping("/findAllMovies")
    public List<Movie> getMovies() {

        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        repo.deleteById(id);

        return "Deleted Successfully";
    }
}
