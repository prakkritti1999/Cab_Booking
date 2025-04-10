package com.CabBooking.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CabBooking.dto.CabsDTO;

@FeignClient(name = "CabService") 
public interface CabsUIClient {
	
    @GetMapping("/api1/cabs/getCabs") // The actual endpoint in the Cabs microservice
    List<CabsDTO> getAvailableCabs(@RequestParam(value = "src") String source, @RequestParam(value = "dest") String destination);
}
