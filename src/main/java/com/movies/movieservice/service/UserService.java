package com.movies.movieservice.service;

import com.movies.movieservice.model.User;

public interface UserService {
    User findUserByUsername(String username);
    void save(User user);
}
