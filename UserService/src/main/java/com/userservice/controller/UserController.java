package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.dao.Users;
import com.userservice.service.UserService;

@Controller
@RequestMapping("/users/")
public class UserController {

	@Autowired UserService userServ;
	
	@GetMapping("home")
	public String home() {
		return "homepage";
	}
	
	@GetMapping("getAll")
	@ResponseBody
	public List<Users> viewAllUsers(){
		System.out.println("Users with us are==="+ userServ.getAllUsers());
		return userServ.getAllUsers();
	}
	
	@PostMapping("saveUser")
	public ResponseEntity<String> saveNewUser(@RequestBody Users users){
		userServ.addNewUser(users);
		return ResponseEntity.ok("User Saved");
	}
	
	
}
