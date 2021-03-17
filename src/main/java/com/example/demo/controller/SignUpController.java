package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private UserRepository userRepository;

    @Autowired
    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp_page";
    }

//На /signUp мы готовы принять нового пользователя и нам его нужно сохр в базе
    @PostMapping("/signUp")
    public String signUpUser(User user){
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/signUp";
    }
}
