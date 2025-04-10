package com.CabBooking.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CabBooking.dto.CabsDTO;
import com.CabBooking.dto.NotificationDTO;
import com.CabBooking.service.CabsUIServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/book_ride/")
public class CabsUIController {

	@Autowired CabsUIServiceImpl cabsUIService;
	
	@GetMapping("home")
	public String home() {
		return "homepage";
	}
	
	@GetMapping("api1/getCabs")
	public ResponseEntity<List<CabsDTO>> getAvailableCabs(@RequestParam("src") String src, @RequestParam("dest") String dest){
		List<CabsDTO> cabs = cabsUIService.getAvailableCabs(src, dest);
		System.out.println("Available Cabs---"+cabs);
		return ResponseEntity.ok(cabs);
	}
	
	@PostMapping("bookCabs")
	public ResponseEntity<String> bookCabs(@RequestParam("cab_id") Long cab_id, 
			@RequestParam("model") String model, 
			@RequestParam("user") String user, 
			@RequestParam("src") String src, 
			@RequestParam("dest") String dest, 
			@RequestParam("baseFare") Integer base_fare, HttpSession session) {
		cabsUIService.bookSelectedCab(cab_id,model,user, src, dest, base_fare);
		session.setAttribute("baseFare", base_fare);
	    return ResponseEntity.ok("Cab Booked"); 
	}
	
	@PostMapping("/sendNotification")
	public ResponseEntity<String> sendNotificationviaSMS(@RequestBody NotificationDTO SMS)
	{
		cabsUIService.sendSMSNotification(SMS);
		return ResponseEntity.ok("Notification Sent");
	}
	
	@GetMapping("ridestart")
	public String ridestart(HttpSession session, Model model) {
		Integer baseFare = (Integer) session.getAttribute("baseFare"); // Retrieve fare from session
	    model.addAttribute("baseFare", baseFare);
		return "cabride";
	}
}
