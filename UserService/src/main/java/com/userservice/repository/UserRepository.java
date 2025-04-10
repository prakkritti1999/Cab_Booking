package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.dao.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}
