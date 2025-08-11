package com.example.user_service.service;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.dto.RegisterDTO;
import com.example.user_service.dto.ResponseDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.exception.GetUserException;
import com.example.user_service.exception.UserAlreadyExistException;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseDTO<User> createUser(RegisterDTO request) throws UserAlreadyExistException {

        if (userRepository.existsByEmail(request.email()) || userRepository.existsByUsername(request.username())) {
            throw new UserAlreadyExistException("User with this email or username already exists");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(request.password());
        userRepository.save(user);
        return new ResponseDTO<>(200, null, "User created successfully", Optional.of(user));
    }

    public UserDTO getUser(String username) throws GetUserException {
        if (username != null)
            return userRepository.getUserByUsername(username);
        throw new GetUserException("no username or other error getting user");
    }
}
