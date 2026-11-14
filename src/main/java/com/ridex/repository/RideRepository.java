package com.ridex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridex.entity.Ride;

public interface RideRepository extends JpaRepository<Ride,Integer>
{
	List<Ride> findByCustomer_CustomerId(Integer customerId);
	long countByRideStatus(String rideStatus);
}
