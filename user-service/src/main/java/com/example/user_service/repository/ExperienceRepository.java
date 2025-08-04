package com.example.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_service.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
