package com.movies.movieservice.service;


import com.movies.movieservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);
    void save(User user);

    List<User> findAllUsers();

}
