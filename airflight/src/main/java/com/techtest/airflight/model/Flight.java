package com.techtest.airflight.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="flight")
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	long id;
	
	@Column(name="flight_number", nullable=false, unique=true)
	String flightNumber;
	
	@Column(name="departure_port")
	String departurePort;
	
	@Column(name="arrival_port")
	String arrivalPort;
	
	@Column(name="airline_code", nullable=false)
	String airlineCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="departure_time")
	Date departureTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="arrival_time")
	Date arrivalTime;
	
	
	
	
}
