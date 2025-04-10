package com.BookingService.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookingService.dao.BookingNotificationDTO;
import com.BookingService.dao.Bookings;
import com.BookingService.service.BookingsService;

@RestController
@RequestMapping("/api2/bookings/")
public class BookingController {

	@Autowired BookingsService bookServ;
	
	@PostMapping("bookAvailableCab")
	public ResponseEntity<Bookings> bookACab(@RequestParam Map<String, String> bookingsDetails){
		Bookings bookedCabs = bookServ.saveBookings(bookingsDetails);
		System.out.println("Cab Booked---"+bookedCabs);
		return ResponseEntity.ok(bookedCabs);
	}
	
	/*
	 * Bookings details are as follows---{cab_id=90245, model=Alto200,
	 * user=Prakriti, src=IGI Airport, dest=Lajpat Nagar, baseFare=400} Hibernate:
	 * insert into bookings
	 * (base_fare,cab_id,cab_model,cab_color,completed_on,destination,driver_name,
	 * driver_licence_no,driver_mob_no,source,started_on,status,username) values
	 * (?,?,?,?,?,?,?,?,?,?,?,?,?) Cab Booked---Bookings(id=14, username=Aditi,
	 * cabId=90245, cabModel=Alto200, cab_color=Bright Red, driverName=Ramu Kaka,
	 * driver_mobNo=null, driver_licence_no=, source=IGI Airport, destination=Lajpat
	 * Nagar, baseFare=400, status=null, startedOn=2025-01-31T19:25:37.040201900,
	 * completedOn=2025-01-31T19:27:37.040201900)
	 */
	
	@PostMapping("/sendSMS")
	public ResponseEntity<String> sendSMS(@RequestBody BookingNotificationDTO bookingNotificationDTO)
	{
		bookServ.sendNotification(bookingNotificationDTO);
		return ResponseEntity.ok("Notification Sent");
	}
}
