package com.techtest.airflight.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class FlightControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	@Order(1)
	void shouldReturnAllFlights() throws Exception 
	{
		String expectedJson = "[{\"id\":1,\"flightNumber\":\"QF400\",\"departurePort\":\"SYD\",\"arrivalPort\":\"MLA\",\"airlineCode\":\"QF\",\"departureTime\":\"2020-06-10T09:00:23.000+00:00\",\"arrivalTime\":\"2020-06-10T10:25:23.000+00:00\"},{\"id\":2,\"flightNumber\":\"EK747\",\"departurePort\":\"SYD\",\"arrivalPort\":\"MEL\",\"airlineCode\":\"EK\",\"departureTime\":\"2020-07-10T09:00:23.000+00:00\",\"arrivalTime\":\"2020-06-10T11:25:23.000+00:00\"},{\"id\":3,\"flightNumber\":\"CX100\",\"departurePort\":\"LAX\",\"arrivalPort\":\"CEB\",\"airlineCode\":\"CX\",\"departureTime\":\"2020-08-10T09:00:23.000+00:00\",\"arrivalTime\":\"2020-06-10T10:25:23.000+00:00\"},{\"id\":4,\"flightNumber\":\"AA999\",\"departurePort\":\"ATL\",\"arrivalPort\":\"BXU\",\"airlineCode\":\"AA\",\"departureTime\":\"2020-09-10T09:00:23.000+00:00\",\"arrivalTime\":\"2020-06-10T10:25:23.000+00:00\"}]";
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.content().json(expectedJson));
	}
	
	@Test
	void shouldReturnFlightWithAirlineCode() throws Exception
	{
		String expectedJson = "[{\"id\":1,\"flightNumber\":\"QF400\",\"departurePort\":\"SYD\",\"arrivalPort\":\"MLA\",\"airlineCode\":\"QF\",\"departureTime\":\"2020-06-10T09:00:23.000+00:00\",\"arrivalTime\":\"2020-06-10T10:25:23.000+00:00\"}]";
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights/QF"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.content().json(expectedJson));
	}
	
	@Test
	void shouldCreateFlight() throws Exception
	{
		String requestJson = "{\"flightNumber\":\"BB143\",\"departurePort\":\"LAX\",\"arrivalPort\":\"SFO\",\"airlineCode\":\"BB\",\"departureTime\":\"2021-09-10T09:00:23.000+00:00\",\"arrivalTime\":\"2021-06-11T10:25:23.000+00:00\"}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/v1/flights")
				.accept(MediaType.APPLICATION_JSON).content(requestJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}

}
