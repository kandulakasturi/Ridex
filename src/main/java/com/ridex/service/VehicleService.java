package com.ridex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ridex.entity.Driver;
import com.ridex.entity.Vehicle;
import com.ridex.repository.DriverRepo;
import com.ridex.repository.VehicleRepository;

@Service
public class VehicleService 
{
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private DriverRepo driverRepository;
	
	public Vehicle registerVehicle(int driverId,Vehicle vehicle)
	{
		Driver driver=driverRepository.findById(driverId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Driver Not Found"));
		vehicle.setDriver(driver);
		
		return vehicleRepository.save(vehicle);
	}
}
