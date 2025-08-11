package com.example.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.dto.ProfileDTO;
import com.example.user_service.service.ProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    
 /*    @PostMapping("/profiles")
    public ProfileDTO Profile (@RequestBody ProfileDTO entity) {
        
    } */
    
}
