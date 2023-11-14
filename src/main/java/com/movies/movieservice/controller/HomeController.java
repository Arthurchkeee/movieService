package com.movies.movieservice.controller;

import com.movies.movieservice.dto.LoginDto;
import com.movies.movieservice.dto.SignUpDto;
import com.movies.movieservice.model.ERole;
import com.movies.movieservice.model.Role;
import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.RoleRepository;
import com.movies.movieservice.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "index";
    }
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("roles",roleRepository.findAll());
        return "registerForm";
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/movies/findAllMovies";
    }

    @PostMapping("/signup")
    public String registerUser(@RequestParam @Valid SignUpDto signUpDto, BindingResult result, Model model) {
        // checking for username exists in a database
        User existingUser = userRepository.findUserByUsername(signUpDto.getUsername());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", signUpDto);
            return "redirect:register";
        }

        // creating user object
        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepository.findByName(ERole.ROLE_ADMIN);
        user.setAuthorities(Collections.singleton(roles));
        userRepository.save(user);
        return "redirect:login";
    }
}
