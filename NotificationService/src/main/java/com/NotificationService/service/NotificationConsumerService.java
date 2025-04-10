package com.NotificationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.NotificationService.dao.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NotificationConsumerService {

	@Autowired private TwilioSmsService twilioSmsService;
    @Autowired private ObjectMapper objectMapper;
	
	@KafkaListener(topics = "booking-notifications", groupId = "Booking_SMS_Notification")
	public void consumeBookingNotification(String message) {
        try {
        	System.out.println("Raw notification data=="+message);
            Notification bookingDetails = objectMapper.readValue(message, Notification.class);
            System.out.println("📩 Booking Notification Received: " + bookingDetails);

            // Send SMS to user
            twilioSmsService.sendSms(bookingDetails);
            
        	} 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
