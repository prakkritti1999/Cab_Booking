package com.BookingService.dao;

import lombok.Data;

@Data
public class CabsDTO {

	private Long cab_id;
	private String model;
	private String cab_color;
	private String cab_licence_plate;
	private String type;
	private Integer baseFare;
	private Integer capacity;
	
	private DriverDTO driverDTO;
}
