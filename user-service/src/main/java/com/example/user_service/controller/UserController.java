package com.example.user_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.dto.RegisterDTO;
import com.example.user_service.dto.ResponseDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.exception.GetUserException;
import com.example.user_service.exception.UserAlreadyExistException;
import com.example.user_service.model.User;
import com.example.user_service.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<User>> createUser(@Valid @RequestBody RegisterDTO user) {
        try {
            return ResponseEntity.ok().body(userService.createUser(user));
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), "user already exists",
                            null));
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<ResponseDTO<UserDTO>> getMethodName(@RequestParam String username) {
        try {
            UserDTO user = userService.getUser(username);
            return ResponseEntity.ok()
                    .body(new ResponseDTO<UserDTO>(HttpStatus.OK.value(), null, "user retrieved", Optional.of(user)));
        } catch (GetUserException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO<UserDTO>(
                    HttpStatus.NOT_FOUND.value(), e.getMessage(), "error getting the user", null));
        }
    }

    /*
     * @GetMapping("/exists")
     * public boolean userExists(@RequestParam String username, @RequestParam String
     * email) {
     * return userService.userExists(username, email);
     * }
     */
}
