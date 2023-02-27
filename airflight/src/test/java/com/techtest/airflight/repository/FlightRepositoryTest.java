package com.techtest.airflight.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.techtest.airflight.model.Flight;

@DataJpaTest
public class FlightRepositoryTest {
	@Autowired
	FlightRepository flightRepository;
	
	@Test
	void findFlightsByAirlineCode()
	{
		List<Flight> flights = flightRepository.findByAirlineCode("AA");
		assertEquals(1, flights.size());
		assertEquals("AA999", flights.get(0).getFlightNumber());
	}

}
