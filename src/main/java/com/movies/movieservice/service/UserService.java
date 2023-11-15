package com.movies.movieservice.service;


import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);
    void save(User user);

    List<User> findAllUsers();
    public static String getAuthenticationUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    public void addMovieToWatchlist(Movie movie);

}
