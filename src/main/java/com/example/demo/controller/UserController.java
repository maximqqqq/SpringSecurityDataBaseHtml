package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//Controller-инструмент обробатывающий http запросы пользователя

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> user = userRepository.findAll();
        model.addAttribute("users", user);
        return "users_page";
//return "users_page"; Название страницы которую мы хотим показать пользователю
    }
}
