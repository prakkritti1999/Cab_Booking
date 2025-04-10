package com.CabBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabBooking.dto.CabsDTO;
import com.CabBooking.dto.NotificationDTO;

@Service
public class CabsUIServiceImpl {
	
	@Autowired CabsUIClient cabsUIClient;
	@Autowired BookingsClient bookingsClient;
	@Autowired NotificationClient notificationCLient;
	
	public List<CabsDTO> getAvailableCabs(String source, String destination) {
		return cabsUIClient.getAvailableCabs(source, destination);
	}

	public CabsDTO bookSelectedCab(Long cab_id, String model, String user, String src, String dest, Integer base_fare) {
		CabsDTO cabs = bookingsClient.bookSeelctedCab(cab_id,model, user, src, dest, base_fare);
		return cabs;
		
	}

	public void sendSMSNotification(NotificationDTO sMS) {
		bookingsClient.sendSMS(sMS);
	}
}