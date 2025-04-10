package com.cabService.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cabs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String licensePlate;

    private String model;

    private String color;

    private Integer capacity;

    private String type; // Economy, Premium, etc.

    private String source;
    
    @Column(name = "base_fare")
    private Integer baseFare;

    private String destination;

    @Enumerated(EnumType.STRING)
    private CabStatus status;

    @OneToOne(mappedBy = "cab")
    private Driver driver;
}

enum CabStatus {
    AVAILABLE, IN_RIDE, MAINTENANCE, OFFLINE
}