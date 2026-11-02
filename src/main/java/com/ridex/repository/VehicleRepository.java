package com.ridex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridex.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> 
{

}
