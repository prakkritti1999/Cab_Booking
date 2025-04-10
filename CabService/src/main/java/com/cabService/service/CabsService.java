package com.cabService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabService.dao.Cabs;
import com.cabService.repository.CabsRepository;

@Service
public class CabsService {

	 	@Autowired
	    private CabsRepository cabsRepository;

	    public List<Cabs> getAvailableCabs(String source, String destination) {
	        return cabsRepository.findAvailableCabs(source, destination);
	    }
}
