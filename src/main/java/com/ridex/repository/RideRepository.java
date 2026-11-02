package com.ridex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridex.entity.Ride;

public interface RideRepository extends JpaRepository<Ride,Integer>
{

}
