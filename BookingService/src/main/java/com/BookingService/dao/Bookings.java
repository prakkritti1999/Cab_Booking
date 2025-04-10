package com.BookingService.dao;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // Local Entity
   
    // Store external service details as simple fields
    private Long cabId;    // Reference to the cab's ID
    private String cabModel; // Additional cab details
    private String cab_color;
    
    private String driverName; // Reference to the driver's name
    private String driver_mobNo;
    private String driver_licence_no;
    
    private String source;
    private String destination;

    private Integer baseFare;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime startedOn;
    private LocalDateTime completedOn;
    
    public enum BookingStatus{
    	COMPLETED, CANCELLED
    }
}


