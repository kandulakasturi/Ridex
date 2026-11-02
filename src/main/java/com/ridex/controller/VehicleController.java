package com.ridex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.entity.Vehicle;
import com.ridex.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController 
{
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/register/{driverId}")
	public String registerVehicle(@PathVariable int driverId,@RequestBody Vehicle vehicle)
	{
		vehicleService.registerVehicle(driverId,vehicle);
		return "Vehicle registered successfully";
	}
}
