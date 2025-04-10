package com.BookingService.dao;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookingNotificationDTO {
	
	private String driver_name;
	private String driver_mobNo;
	private String cabModel;
	private String cab_color;
	private String cab_plate_no;
	private Integer baseFare;
	
	public BookingNotificationDTO(CabsWithDriverDTO cab) {
        this.cabModel = cab.getModel();
        this.driver_name = cab.getDriverName();
        this.driver_mobNo = cab.getDriverPhone();
        this.cab_color = cab.getCab_color();
        this.baseFare = cab.getBaseFare();
    }
}
