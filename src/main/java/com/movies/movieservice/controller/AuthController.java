package com.movies.movieservice.controller;

import com.movies.movieservice.model.User;
import com.movies.movieservice.repository.RoleRepo;
import com.movies.movieservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String home(){
        return "index";
    }
    @Autowired
    RoleRepo roleRepo;
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("roles",roleRepo.findAll());
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(User userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByUsername(userDto.getUsername());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userService.save(userDto);
        return "redirect:/register?success";
    }
}
