package com.movies.movieservice.service;


import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.dto.SignUpDto;
import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.User;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);
    void save(User user);

    List<User> findAllUsers();
    void addMovieToWatchlist(Movie movie);

}
