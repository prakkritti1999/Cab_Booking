package com.cabService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabService.dao.Cabs;
import com.cabService.service.CabsService;

@RestController
@RequestMapping("/api1/cabs/")
public class CabsController {

	@Autowired CabsService cabsService;
	
	@GetMapping("getCabs")
	public List<Cabs> getAvailableCabs(@RequestParam("src") String source, @RequestParam("dest") String destination) {
        return cabsService.getAvailableCabs(source, destination);
    }
}
