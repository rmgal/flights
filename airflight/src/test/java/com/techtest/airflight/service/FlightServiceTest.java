package com.techtest.airflight.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.techtest.airflight.model.Flight;
import com.techtest.airflight.repository.FlightRepository;
import com.techtest.airflight.service.impl.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {
	@InjectMocks
	FlightServiceImpl flightService;
	
	@Mock
	FlightRepository flightRepository;
	
	@Test
	void getAllFlightsTest()
	{
		final var expectedFlight = Flight.builder()
				.id(1)
				.flightNumber("ZZ123")
				.airlineCode("ZZ")
				.arrivalPort("GBR")
				.departurePort("SFO")
				.departureTime(new Date())
				.arrivalTime(new Date())
				.build();
		
		final var expectedFlight2 = Flight.builder()
				.id(1)
				.flightNumber("XX123")
				.airlineCode("XX")
				.arrivalPort("LAX")
				.departurePort("SFO")
				.departureTime(new Date())
				.arrivalTime(new Date())
				.build();
		
		when(flightRepository.findAll()).thenReturn(List.of(expectedFlight, expectedFlight2));
		
		final var actual = flightService.getAllFlights();
		
		assertEquals(actual.size(), 2);
	}
	
	@Test
	void getFlightsByAirlineCodeTest()
	{
		final var expectedFlight = Flight.builder()
				.id(1)
				.flightNumber("YY123")
				.airlineCode("YY")
				.arrivalPort("GBR")
				.departurePort("SFO")
				.departureTime(new Date())
				.arrivalTime(new Date())
				.build();	
		
		when(flightRepository.findByAirlineCode(anyString())).thenReturn(List.of(expectedFlight));
		
		final var actual = flightService.getFlightsByAirlineCode("YY");
		
		assertEquals(actual.size(), 1);
		assertEquals(actual.get(0).getAirlineCode(), expectedFlight.getAirlineCode());
	}
	
	@Test
	void createFlightTest()
	{
		final var flightToSave = Flight.builder()
				.id(1)
				.flightNumber("WW123")
				.airlineCode("WW")
				.arrivalPort("GBR")
				.departurePort("SFO")
				.departureTime(new Date())
				.arrivalTime(new Date())
				.build();
		
		when(flightRepository.save(any(Flight.class))).thenReturn(flightToSave);

        final var actual = flightService.createFlight(new Flight());

        assertThat(actual).usingRecursiveComparison().isEqualTo(flightToSave);
        verifyNoMoreInteractions(flightRepository);
	}
}
