package com.ridex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridex.entity.Driver;

public interface DriverRepo extends JpaRepository<Driver,Integer> 
{
	List<Driver> findByAvailabilityStatus(String availabilityStatus);
}
