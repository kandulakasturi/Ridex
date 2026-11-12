package com.ridex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ridex.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> 
{
	Optional<Payment> findByRide_RideId(int rideId);
	List<Payment> findByRide_Customer_CustomerId(int customerId);
}
