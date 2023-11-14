package com.movies.movieservice.controller;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private MovieService movieService;
    @PostMapping(value = "/addMovie")
    public String saveMovie(Movie movie, @RequestParam("poster") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            file.transferTo( new File(uploadPath +"/"+ fileName));
            movie.setFilePath("/movieService/" + fileName);
            movieService.addMovie(movie);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:findAllMovies";
    }

    @GetMapping("/addMovie")
    public String addMovie(){
        return "addMovie";
    }
    @GetMapping("/findAllMovies")
    public String getMovies(Model model) {
        model.addAttribute("movies",movieService.getAllMovies());
        return "movieList";
    }
    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable String id, Model model){
        Optional<Movie> movie=movieService.getMovieById(id);
        movie.ifPresent(value -> model.addAttribute("movie", value));
        return "filmPage";
    }

    @PostMapping("/delete")
    public String deleteMovie(@RequestParam("id") String id) {
        movieService.deleteMovie(id);

        return "Deleted Successfully";
    }
}
