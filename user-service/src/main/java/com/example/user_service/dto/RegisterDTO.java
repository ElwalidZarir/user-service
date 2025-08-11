package com.example.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDTO(
        @NotBlank(message = "Name is required") String username,
        @Email(message = "Email should be valid") String email,
        @NotBlank @NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters long") String password) {
}