package com.example.user_service.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Profile {
    @Id
    private int id;
    private String bio;
    private String location;
    private String website;
    private String phoneNumber; 

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
