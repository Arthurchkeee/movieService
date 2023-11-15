package com.movies.movieservice.controller;

import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.dto.SignUpDto;
import com.movies.movieservice.model.ERole;
import com.movies.movieservice.model.Role;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.RoleRepository;
import com.movies.movieservice.repository.UserRepository;
import com.movies.movieservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AuthController {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @GetMapping("/login")
    public String login(){
        return "index";
    }
    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("roles",roleRepository.findAll());
        return "registerForm";
    }

    @PostMapping("/login")
    public String authenticateUser(@Valid SignInDto loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);


        return "redirect:/movies/findAllMovies";
    }

    @PostMapping("/signup")
    public String registerUser(@Valid SignUpDto signUpDto) throws Exception {
        if (userService.findUserByUsername(signUpDto.getUsername()).isPresent()) {
            throw new Exception("Error: Username is already taken!");
        }

        // Create new user's account
        User user = new User(signUpDto.getUsername(),
                encoder.encode(signUpDto.getPassword()),
                signUpDto.getEmail(),signUpDto.getAuthorities());

        userRepository.save(user);

        return "redirect:signup?";
    }
}
