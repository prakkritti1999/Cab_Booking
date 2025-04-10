package com.NotificationService.dao;

import org.springframework.stereotype.Component;

@Component
public class Notification {

	/*
	 * private String to_number; private String from_number; private String message;
	 * public Notification(String to_number, String from_number, String message) {
	 * super(); this.to_number = to_number; this.from_number = from_number;
	 * this.message = message; } public Notification() { super(); // TODO
	 * Auto-generated constructor stub } public String getTo_number() { return
	 * to_number; } public void setTo_number(String to_number) { this.to_number =
	 * to_number; } public String getFrom_number() { return from_number; } public
	 * void setFrom_number(String from_number) { this.from_number = from_number; }
	 * public String getMessage() { return message; } public void setMessage(String
	 * message) { this.message = message; }
	 */
	private String driver_name;
	private String driver_mobNo;
	private String cabModel;
	private String cab_color;
	private String cab_plate_no;
	private Integer baseFare;
	
	public Notification(String driver_name, String driver_mobNo, String cabModel, String cab_color, String cab_plate_no,
			Integer baseFare) {
		super();
		this.driver_name = driver_name;
		this.driver_mobNo = driver_mobNo;
		this.cabModel = cabModel;
		this.cab_color = cab_color;
		this.cab_plate_no = cab_plate_no;
		this.baseFare = baseFare;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public String getDriver_mobNo() {
		return driver_mobNo;
	}
	public void setDriver_mobNo(String driver_mobNo) {
		this.driver_mobNo = driver_mobNo;
	}
	public String getCabModel() {
		return cabModel;
	}
	public void setCabModel(String cabModel) {
		this.cabModel = cabModel;
	}
	public String getCab_color() {
		return cab_color;
	}
	public void setCab_color(String cab_color) {
		this.cab_color = cab_color;
	}
	public String getCab_plate_no() {
		return cab_plate_no;
	}
	public void setCab_plate_no(String cab_plate_no) {
		this.cab_plate_no = cab_plate_no;
	}
	public Integer getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(Integer baseFare) {
		this.baseFare = baseFare;
	}
	@Override
	public String toString() {
		return "Notification [driver_name=" + driver_name + ", driver_mobNo=" + driver_mobNo + ", cabModel=" + cabModel
				+ ", cab_color=" + cab_color + ", cab_plate_no=" + cab_plate_no + ", baseFare=" + baseFare + "]";
	}
}
