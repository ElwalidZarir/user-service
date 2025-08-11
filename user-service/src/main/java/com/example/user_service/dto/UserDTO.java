package com.example.user_service.dto;

import java.util.Optional;

public record UserDTO(
                String username,
                Optional<String> email,
                Optional<String> password
        

) {
}
