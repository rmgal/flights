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

import lombok.Data;

@Entity
@Data
@Table(name="flight", schema="airport")
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	long flightNumber;
	
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
