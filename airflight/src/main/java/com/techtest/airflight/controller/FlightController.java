package com.techtest.airflight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techtest.airflight.model.Flight;
import com.techtest.airflight.service.FlightService;

@RestController
@RequestMapping("/api")
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value = "/flights", method=RequestMethod.GET)
	public List<Flight> getAllFlights() 
	{
        return flightService.getAllFlights();
    }
	
	@RequestMapping(value = "/flights", method=RequestMethod.POST)
	public Flight createFlight(@RequestBody Flight flight) 
	{
        return flightService.createFlight(flight);
    }
	
	@RequestMapping(value = "/flights/{airlineCode}", method=RequestMethod.GET)
    public List<Flight> getFlightsByArilineCode(@PathVariable String airlineCode) 
	{
        return flightService.getFlightsByAirlineCode(airlineCode);
    }
}
