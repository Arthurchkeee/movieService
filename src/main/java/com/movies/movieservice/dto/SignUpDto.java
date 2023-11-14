package com.movies.movieservice.dto;

import com.movies.movieservice.model.Role;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDto{
    private String username;
    @Email
    private String email;
    private String password;
    private Set<Role> authorities;
}
