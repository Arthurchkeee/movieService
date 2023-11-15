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
    public String authenticateUser(@Valid @RequestParam SignInDto loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);


        return "redirect:/movies/findAllMovies";
    }

    @PostMapping("/signup")
    public String registerUser(String username,String email,String password,String[] authorities) throws Exception {
        if (userService.findUserByUsername(username).isPresent()) {
            throw new Exception("Error: Username is already taken!");
        }

        // Create new user's account
        User user = new User(username,
                encoder.encode(password),
                email);

        Set<String> strRoles = new HashSet<>(List.of(authorities));
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ROLE_ADMIN":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "ROLE_MODERATOR":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setAuthorities(roles);
        userRepository.save(user);

        return "redirect:signup?success";
    }
}
