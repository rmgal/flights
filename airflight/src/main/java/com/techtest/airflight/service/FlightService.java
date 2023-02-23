package com.techtest.airflight.service;

import java.util.List;

import com.techtest.airflight.model.Flight;

public interface FlightService {
	public Flight createFlight(Flight flight);
	public List<Flight> getAllFlights();
	public List<Flight> getFlightsByAirlineCode(String airlineCode);
}
