package com.ridex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridex.entity.Driver;
import com.ridex.repository.DriverRepo;

@Service
public class DriverService 
{
	@Autowired
	private DriverRepo driverRepository;
	
	public Driver registerDriver(Driver driver)
	{
		return driverRepository.save(driver);
	}
}
