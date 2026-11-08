package com.ridex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ridex.entity.Customer;
import com.ridex.entity.Driver;
import com.ridex.entity.Ride;
import com.ridex.repository.CustomerRepository;
import com.ridex.repository.DriverRepo;
import com.ridex.repository.RideRepository;
@Service
public class RideService 
{
	@Autowired
	private RideRepository rideRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DriverRepo driverRepo;
	
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
	
	public Ride assignDriver(int rideId) {

	    Ride ride = rideRepository.findById(rideId)
	            .orElseThrow(() -> new ResponseStatusException(
	                    HttpStatus.NOT_FOUND, "Ride Not Found"));

	    if (!"REQUESTED".equals(ride.getRideStatus())) {
	        throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "Ride is not available for assignment");
	    }

	    if (ride.getDriver() != null) {
	        throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST, "Driver already assigned");
	    }

	    List<Driver> drivers =
	            driverRepo.findByAvailabilityStatus("AVAILABLE");

	    if (drivers.isEmpty()) {
	        throw new ResponseStatusException(
	                HttpStatus.NOT_FOUND, "No Available Drivers");
	    }

	    Driver driver = drivers.get(0);

	    ride.setDriver(driver);
	    ride.setRideStatus("ACCEPTED");

	    driver.setAvailabilityStatus("BUSY");

	    driverRepo.save(driver);

	    return rideRepository.save(ride);
	}
}
