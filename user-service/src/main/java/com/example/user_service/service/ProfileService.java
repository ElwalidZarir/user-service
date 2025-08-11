package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.example.user_service.controller.ProfileController;
import com.example.user_service.dto.ResponseDTO;
import com.example.user_service.dto.ProfileDTO;
import com.example.user_service.exception.ProfileCreationFailed;
import com.example.user_service.model.Profile;
import com.example.user_service.model.User;
import com.example.user_service.repository.ProfileRepository;
import com.example.user_service.repository.UserRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private UserRepository userRepository;

 /*    public ResponseDTO createProfile(ProfileDTO profileDTO) throws ProfileCreationFailed {
        if(profileDTO==null){
            throw new ProfileCreationFailed("profile data can't be null");
        }   
        Profile profile = new Profile();
        profile.setBio(profileDTO.bio());
        profile.setLocation(profileDTO.location());
        profile.setWebsite(profileDTO.website());
        profile.setPhoneNumber(profileDTO.phoneNumber());
        profileRepository.save(profile);
        return new ResponseDTO(null, "profile succesfuly created");
    } */
}
