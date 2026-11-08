package com.ridex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.entity.Ride;
import com.ridex.service.RideService;

@RestController
@RequestMapping("/ride")
public class RideController 
{
	@Autowired
	private RideService rideService;
	
	@PostMapping("/book/{id}")
	public Ride bookRide(@PathVariable("id") int customerId,@RequestBody Ride ride)
	{
		return rideService.bookRide(customerId, ride);
	}
	
	@PutMapping("/assign/{rideId}")
	public Ride assignDriver(@PathVariable("rideId") int rideId) {
	    return rideService.assignDriver(rideId);
	}
	
	@PutMapping("/start/{rideId}")
	public Ride startRide(@PathVariable("rideId") int rideId)
	{
	    return rideService.startRide(rideId);
	}

	@PutMapping("/complete/{rideId}")
	public Ride completeRide(@PathVariable("rideId") int rideId)
	{
	    return rideService.completeRide(rideId);
	}
	
	@PutMapping("/cancel/{rideId}")
	public Ride cancelRide(@PathVariable("rideId") int rideId)
	{	
		return rideService.cancelRide(rideId);
	}

}
