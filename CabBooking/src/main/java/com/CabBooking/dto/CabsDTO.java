package com.CabBooking.dto;

import lombok.Data;

@Data
public class CabsDTO {
	
    private Integer capacity;
    private String type; // Economy, Premium, etc.
    private Integer baseFare;
    
    
    private Long id;
	private String model;
	private String color;
	private String licensePlate;

    private String licenseNo;
    private String driverName;
    private String driverPhone;
}
