package com.movies.movieservice.service;

import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.dto.SignUpDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public interface AuthService {
    void authenticateUser(SignInDto loginRequest);
    void registerUser( SignUpDto signUpDto) throws Exception;
    static String getAuthenticationUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
