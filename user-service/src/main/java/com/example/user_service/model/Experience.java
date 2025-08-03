package com.example.user_service.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Experience {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String companyName;
    private String jobTitle;
    private String startDate;
    private String endDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
}
