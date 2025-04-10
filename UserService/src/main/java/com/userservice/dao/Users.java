package com.userservice.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Users")
public class Users {

	private String name;
	private String mobNo;
	private String emailId;
	
	@Id
	private String username;
	private String password;
}
