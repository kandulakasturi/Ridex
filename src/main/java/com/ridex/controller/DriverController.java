package com.ridex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.entity.Driver;
import com.ridex.service.DriverService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/driver")
public class DriverController 
{
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/register")
	public Driver registerDriver(@Valid @RequestBody Driver driver)
	{
		return driverService.registerDriver(driver);
	}
}
