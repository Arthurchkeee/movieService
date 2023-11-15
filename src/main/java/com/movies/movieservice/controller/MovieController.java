package com.movies.movieservice.controller;

import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.UserRepository;
import com.movies.movieservice.service.MovieService;
import com.movies.movieservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Secured({"ROLE_ADMIN","ROLE_MODERATOR"})
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
    @Secured({"ROLE_ADMIN","ROLE_MODERATOR"})
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
    @Secured({"ROLE_ADMIN","ROLE_MODERATOR"})
    @PostMapping("/delete")
    public String deleteMovie(@RequestParam("id") String id) {
        movieService.deleteMovie(id);

        return "Deleted Successfully";
    }
    @PostMapping("/addToWatchlist")
    public String addToWatchlist(@RequestParam Movie movie){
        userService.addMovieToWatchlist(movie);
        return "redirect:/movies/movie/"+movie.getId();
    }
    @GetMapping("/watchlist")
    public String showWatchlist(Model model){
        Optional<User> user=userService.findUserByUsername(UserService.getAuthenticationUserName());
        user.ifPresent(value -> model.addAttribute("movies", value.getWatchlist()));
        return "movieList";
    }
}
