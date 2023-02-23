package com.techtest.airflight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtest.airflight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findByAirlineCode(String airlineCode);
}
