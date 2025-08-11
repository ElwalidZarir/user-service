package com.example.user_service.dto;

import java.util.Optional;

import org.springframework.http.HttpStatus;

public record ResponseDTO<T>(
                int status,
                String error,
                String message,
                Optional<T> data) {
}