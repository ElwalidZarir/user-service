package com.example.user_service.dto;

public record Experience(
        String companyName,
        String jobTitle,
        String startDate,
        String endDate,
        String description) {
}
