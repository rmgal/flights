package com.techtest.airflight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtest.airflight.model.Flight;
import com.techtest.airflight.repository.FlightRepository;
import com.techtest.airflight.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	
	@Override
	public List<Flight> getFlightsByAirlineCode(String airlineCode) {
		
		return flightRepository.findByAirlineCode(airlineCode);
	}


	@Override
	public List<Flight> getAllFlights() {
	
		return flightRepository.findAll();
	}


	@Override
	public Flight createFlight(Flight flight) {
		
		return flightRepository.save(flight);
	}

}
