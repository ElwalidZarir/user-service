package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.dto.RegisterRequestDTO;
import com.example.user_service.dto.RegisterResponseDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public RegisterResponseDTO createUser(RegisterRequestDTO request) {
        try {
            if (userRepository.existsByEmail(request.email())) {
                return new RegisterResponseDTO("Email already exists", "User creation failed");
            } else {
                User user = new User();
                user.setUsername(request.username());
                user.setEmail(request.email());
                user.setPassword(request.password());
                userRepository.save(user);
                return new RegisterResponseDTO(null, "User created successfully");
            }

        } catch (Exception e) {
            return new RegisterResponseDTO(e.getMessage(), "Error creating user");
        }

    }

    public boolean doesUserExist(UserDTO user) {
        try {
            return userRepository.existsByEmail(user.email()) || userRepository.existsByUsername(user.username());
        } catch (Exception e) {
            throw new RuntimeException("Error checking user existence: " + e.getMessage());
        }
    }
}
