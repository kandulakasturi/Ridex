package com.ridex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.entity.Payment;
import com.ridex.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController 
{
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("make/{rideId}")
	public String makePayment(@PathVariable int rideId,@RequestParam String paymentMethod)
	{
		return paymentService.makePayment(rideId, paymentMethod);
	}
	
	@GetMapping("/details/{paymentId}")
	public Payment getPaymentById(@PathVariable int paymentId)
	{
		return paymentService.getPaymentById(paymentId);
	}
	

	@GetMapping("/history/{customerId}")
	public List<Payment> getCustomerPaymentHistory(@PathVariable int customerId) 
	{
		return paymentService.getCustomerPaymentHistory(customerId);
	}
}
