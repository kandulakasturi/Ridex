package com.ridex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ridex.entity.Customer;
import com.ridex.entity.Ride;
import com.ridex.repository.CustomerRepository;
import com.ridex.repository.RideRepository;

@Service
public class RideService 
{
	@Autowired
	private RideRepository rideRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Ride bookRide(int customerId,Ride ride)
	{
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));
		if(ride.getDistance()<=0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Distance");
		}
		
		double fare=50+(ride.getDistance()*12);
		
		ride.setEstimatedFare(fare);
		
		ride.setCustomer(customer);
		
		ride.setRideStatus("REQUESTED");
		
		return rideRepository.save(ride);
	}
}
