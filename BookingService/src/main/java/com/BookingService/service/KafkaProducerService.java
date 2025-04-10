package com.BookingService.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.BookingService.dao.BookingNotificationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducerService {

	
	private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void sendBookingNotification(BookingNotificationDTO bookingDetails) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String bookingJson = objectMapper.writeValueAsString(bookingDetails);
            kafkaTemplate.send("booking-notifications", bookingJson);
            
            System.out.println("📡 Booking event published to Kafka: " + bookingJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
