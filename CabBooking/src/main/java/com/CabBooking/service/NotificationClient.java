package com.CabBooking.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "NotificationService")
public interface NotificationClient {

	@GetMapping("/api3/sendSMS")
	void sendSMS();
	
}
