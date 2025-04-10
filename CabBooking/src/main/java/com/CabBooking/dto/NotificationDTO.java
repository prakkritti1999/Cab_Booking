package com.CabBooking.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class NotificationDTO {
	private String driver_name;
	private String driver_mobNo;
	private String cabModel;
	private String cab_color;
	private String cab_plate_no;
	private Integer baseFare;
}
