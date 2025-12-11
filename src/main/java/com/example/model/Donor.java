package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "donors")
public class
Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodGroup;
    private String city;
    private LocalDate lastDonation;

    @OneToOne
    private User user;
}
