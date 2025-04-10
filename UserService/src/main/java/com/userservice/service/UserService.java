package com.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.dao.Users;
import com.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userRepo;
	
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
	
	public void addNewUser(Users user) {
		userRepo.save(user);
	}
}
