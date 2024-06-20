package com.movies.movieservice.service.impl;

import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.dto.SignUpDto;
import com.movies.movieservice.model.User;
import com.movies.movieservice.service.AuthService;
import com.movies.movieservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;

    @Override
    public void authenticateUser(SignInDto loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void registerUser(SignUpDto signUpDto) throws Exception {
        if (userService.findUserByUsername(signUpDto.getUsername()).isPresent()) {
            throw new Exception("Error: Username is already taken!");
        }

        // Create new user's account
        User user = new User(signUpDto.getUsername(),
                encoder.encode(signUpDto.getPassword()),
                signUpDto.getEmail(),signUpDto.getAuthorities());

        userService.save(user);
    }
}
