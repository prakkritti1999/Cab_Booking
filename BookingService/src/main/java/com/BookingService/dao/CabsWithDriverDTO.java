package com.BookingService.dao;

import lombok.Data;

@Data
public class CabsWithDriverDTO {

	private Long cab_id;
	private String model;
	private String cab_color;
	private String cab_licence_plate;

    private String driverLicenceNo;
    private String driverName;
    private String driverPhone;
	private String type;
	private Integer baseFare;
	private Integer capacity;
    
    
    // Constructor
    public CabsWithDriverDTO(CabsDTO cab) {
        this.cab_id = cab.getCab_id();
        this.model = cab.getModel();
        this.type = cab.getType();
        this.baseFare = cab.getBaseFare();
        this.capacity = cab.getCapacity();
        this.cab_color = cab.getCab_color();

        this.driverName = cab.getDriverDTO().getDriver_name();
        this.driverLicenceNo = cab.getDriverDTO().getLicenseNo();
        this.driverPhone = cab.getDriverDTO().getMobno();
    }
}
