package com.example.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.dto.RegisterRequestDTO;
import com.example.user_service.dto.RegisterResponseDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.model.User;
import com.example.user_service.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegisterResponseDTO createUser(@Valid @RequestBody RegisterRequestDTO user) {
        return userService.createUser(user);
    }

    @GetMapping("/exists")
    public boolean doesUserExist(@RequestParam UserDTO user) {
        return userService.doesUserExist(user);
    }
    
    
}
