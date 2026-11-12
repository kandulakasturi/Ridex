package com.ridex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ridex.entity.Payment;
import com.ridex.entity.Ride;
import com.ridex.repository.PaymentRepository;
import com.ridex.repository.RideRepository;

@Service
public class PaymentService 
{
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private RideRepository rideRepository;
	
	public String makePayment(int rideId,String paymentMethod)
	{
		Ride ride=rideRepository.findById(rideId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ride Not Found"));
		
		if(!ride.getRideStatus().equals("COMPLETED"))
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Ride is not completed");
		}
		
		Payment payment = new Payment();
		payment.setRide(ride);
		payment.setAmount(ride.getDistance()*10);
		payment.setPaymentMethod(paymentMethod);
		payment.setPaymentStatus("SUCCESS");
		
		paymentRepository.save(payment);
		
		return "Payment Successfull";
	}
}
