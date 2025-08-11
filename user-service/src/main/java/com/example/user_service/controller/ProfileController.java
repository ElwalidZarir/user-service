package com.example.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.dto.ResponseDTO;
import com.example.user_service.dto.ProfileDTO;
import com.example.user_service.exception.ProfileCreationFailed;
import com.example.user_service.service.ProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    
    /* @PostMapping("/profiles")
    public ResponseEntity<ResponseDTO> createProfile(@RequestBody ProfileDTO profile) {
        try{
            return ResponseEntity.ok().body(profileService.createProfile(profile));
        } catch(ProfileCreationFailed e){
            return ResponseEntity.badRequest().body(new ResponseDTO(e.getMessage(), "Error creating the profile"));
        }
    } */
    
}
