package com.BookingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookingService.dao.Bookings;

public interface BookingsRespository extends JpaRepository<Bookings, Long>{

}
