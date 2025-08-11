package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.dto.RegisterRequestDTO;
import com.example.user_service.dto.RegisterResponseDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.exception.UserAlreadyExistException;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public RegisterResponseDTO createUser(RegisterRequestDTO request) throws UserAlreadyExistException {

        if (userRepository.existsByEmail(request.email()) || userRepository.existsByUsername(request.username())) {
            throw new UserAlreadyExistException("User with this email or username already exists");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(request.password());
        userRepository.save(user);
        System.out.println("User created successfully: " + user);
        return new RegisterResponseDTO(null, "User created successfully");

    }

}
