package com.movies.movieservice.service.impl;


import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.dto.SignUpDto;
import com.movies.movieservice.model.Movie;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.UserRepository;
import com.movies.movieservice.service.AuthService;
import com.movies.movieservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void addMovieToWatchlist(Movie movie){
        Optional<User> user= userRepository.findUserByUsername(AuthService.getAuthenticationUserName());
        if (user.isPresent()){
            Set<Movie> watchlist=user.get().getWatchlist();
            watchlist.add(movie);
            userRepository.save(user.get());
        }

    }
    @Override
    public List<User> findUsersByUsernameSubstring(String usernameSubstring) {
        return userRepository.findUsersByUsernameSubstring(usernameSubstring);
    }

}
