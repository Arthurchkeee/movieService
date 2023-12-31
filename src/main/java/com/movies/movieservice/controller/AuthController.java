package com.movies.movieservice.controller;

import com.movies.movieservice.dto.SignInDto;
import com.movies.movieservice.dto.SignUpDto;
import com.movies.movieservice.model.ERole;
import com.movies.movieservice.model.Role;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.RoleRepository;
import com.movies.movieservice.repository.UserRepository;
import com.movies.movieservice.service.AuthService;
import com.movies.movieservice.service.ReviewService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ReviewService reviewService;

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
        authService.authenticateUser(loginRequest);


        return "redirect:/movies/findAllMovies";
    }

    @PostMapping("/signup")
    public String registerUser(@Valid SignUpDto signUpDto) throws Exception {
        authService.registerUser(signUpDto);

        return "redirect:signup?";
    }
    @GetMapping("/user/{user}")
    public String getUserPage(@PathVariable User user,Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        model.addAttribute("reviews",reviewService.findReviewsByUser(user));
        return "userPage";
    }
}
