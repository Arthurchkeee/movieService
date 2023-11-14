package com.movies.movieservice.service.impl;

import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.UserRepo;
import com.movies.movieservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }
}
