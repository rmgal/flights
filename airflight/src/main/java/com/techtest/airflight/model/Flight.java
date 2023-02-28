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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="flight")
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	long id;
	
	@NotNull
	@Size(min=5, message="Flight number should be at least 5 alphanumeric characters")
	@Column(name="flight_number", nullable=false, unique=true)
	String flightNumber;
	
	@NotNull
	
	@Column(name="departure_port")
	String departurePort;
	
	@NotNull
	@Column(name="arrival_port")
	String arrivalPort;
	
	@NotNull
	@Column(name="airline_code", nullable=false)
	String airlineCode;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="departure_time")
	Date departureTime;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="arrival_time")
	Date arrivalTime;
	
	
	
	
}
