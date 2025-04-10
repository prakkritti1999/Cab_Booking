package com.BookingService.dao;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DriverDTO {

	private String driver_name;
	private String mobno;
    private String licenseNo;
    private Integer rating;
}
