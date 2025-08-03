package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.dto.RegisterRequest;
import com.example.user_service.dto.RegisterResponse;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public RegisterResponse createUser(RegisterRequest request) {
        try {
            if (userRepository.existsByEmail(request.email())) {
                return new RegisterResponse("Email already exists", "User creation failed");
            } else {
                User user = new User();
                user.setUsername(request.username());
                user.setEmail(request.email());
                user.setPassword(request.password());
                userRepository.save(user);
                return new RegisterResponse(null, "User created successfully");
            }

        } catch (Exception e) {
            return new RegisterResponse(e.getMessage(), "Error creating user");
        }

    }
}
