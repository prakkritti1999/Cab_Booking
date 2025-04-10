package com.CabBooking.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.CabBooking.dto.CabsDTO;
import com.CabBooking.dto.NotificationDTO;

@FeignClient(name = "BookingService") 
public interface BookingsClient {

    @PostMapping("/api2/bookings/bookAvailableCab")
    CabsDTO bookSeelctedCab(@RequestParam("cab_id") Long cabId,
                         @RequestParam("model") String model,
                         @RequestParam("user") String user, 
                         @RequestParam("src") String src, 
                         @RequestParam("dest") String dest, 
                         @RequestParam("baseFare") Integer base_fare);
    
    @PostMapping("/api2/bookings/sendSMS")
	void sendSMS(@RequestBody NotificationDTO sMS);
}
