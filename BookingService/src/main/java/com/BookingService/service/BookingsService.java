package com.BookingService.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookingService.dao.BookingNotificationDTO;
import com.BookingService.dao.Bookings;
import com.BookingService.repository.BookingsRespository;

@Service
public class BookingsService {

	@Autowired BookingsRespository bookRepo;
	@Autowired KafkaProducerService kafkaProducerService;
	
	public Bookings saveBookings(Map<String, String> bookingsDetails){
		
		System.out.println("Bookings details are as follows---"+bookingsDetails);
		Bookings bookings = new Bookings();
		bookings.setBaseFare(Integer.parseInt(bookingsDetails.get("baseFare")));
		bookings.setCabId(Long.parseLong(bookingsDetails.get("cab_id")));
		bookings.setCabModel(bookingsDetails.get("model"));
		bookings.setStartedOn(LocalDateTime.now());
		bookings.setCompletedOn(LocalDateTime.now().plusMinutes(2));
		bookings.setSource(bookingsDetails.get("src"));
		bookings.setDestination(bookingsDetails.get("dest"));
		bookings.setDriverName(bookingsDetails.get("driverName"));
		bookings.setUsername("Aditi");
		bookings.setCab_color(bookingsDetails.get("color"));
		bookings.setDriver_licence_no(bookingsDetails.get("licenseNo"));
		bookings.setDriver_mobNo(bookingsDetails.get("driverPhone"));
		bookings.setStatus(Bookings.BookingStatus.COMPLETED);
		bookRepo.save(bookings);
		return bookings;
	}
	
	public void sendNotification(BookingNotificationDTO bookingNotificationDTO) {
		kafkaProducerService.sendBookingNotification(bookingNotificationDTO);
	}
}
