package com.cabService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cabService.dao.Cabs;

public interface CabsRepository extends JpaRepository<Cabs, Long> {

	@Query("SELECT c FROM Cabs c WHERE c.source = :src AND c.destination = :dest AND c.status = 'AVAILABLE'")
    List<Cabs> findAvailableCabs(@Param("src") String source, @Param("dest") String destination);
}
