package com.movies.movieservice.controller;

import com.movies.movieservice.dto.FindMovieByFilter;
import com.movies.movieservice.dto.SendReviewDto;
import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.Review;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.UserRepository;
import com.movies.movieservice.service.*;
import org.bson.types.ObjectId;
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
import java.util.List;
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
    private CountryService countryService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private ReviewService reviewService;

    @Secured(value = {"ROLE_ADMIN", "ROLE_MODERATOR"})
    @PostMapping(value = "/addMovie")
    public String saveMovie(Movie movie, @RequestParam("poster") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + fileName));
            movie.setFilePath("/movieService/" + fileName);
            movieService.addMovie(movie);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:findAllMovies";
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_MODERATOR"})
    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("genres", genreService.findAll());
        return "addMovie";
    }

    @GetMapping("/findMoviesByFilter")
    public String findMoviesByFilter(FindMovieByFilter findMovieByFilter, Model model) throws Exception {
        model.addAttribute("movies", movieService.findMovieByFilter(findMovieByFilter));
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("genres", genreService.findAll());
        return "movieList";
    }

    @GetMapping("/findAllMovies")
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("genres", genreService.findAll());
        return "movieList";
    }

    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable ObjectId id, Model model) throws Exception {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
        } else {
            throw new Exception("IOException, id="+id);
        }
        movie.ifPresent(value -> model.addAttribute("movie", value));
        return "filmPage";
    }

    @Secured({"ROLE_ADMIN", "ROLE_MODERATOR"})
    @PostMapping("/delete")
    public String deleteMovie(@RequestParam("id") ObjectId id) {
        movieService.deleteMovie(id);

        return "Deleted Successfully";
    }

    @PostMapping("/addToWatchlist")
    public String addToWatchlist(@RequestParam Movie movie) {
        userService.addMovieToWatchlist(movie);
        return "redirect:/movies/movie/" + movie.getId();
    }

    @GetMapping("/watchlist")
    public String showWatchlist(Model model) {
        Optional<User> user = userService.findUserByUsername(AuthService.getAuthenticationUserName());
        user.ifPresent(value -> model.addAttribute("movies", value.getWatchlist()));
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("genres", genreService.findAll());
        return "movieList";
    }
    @PostMapping("/sendReview")
    public String sendReview( SendReviewDto sendReviewDto){
        Review review=new Review();
        review.setMovie(sendReviewDto.getMovie());
        review.setTextOfReview(sendReviewDto.getTextOfReview());
        review.setTitle(sendReviewDto.getTitle());
        review.setMark(sendReviewDto.getMark());
        review.setUser(userService.findUserByUsername(AuthService.getAuthenticationUserName()).get());
        reviewService.saveReview(review);
        return "redirect:findAllMovies";
    }
}
