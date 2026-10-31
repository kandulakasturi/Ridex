package com.ridex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.entity.Customer;
import com.ridex.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer)
	{
		return customerService.registerCustomer(customer);
	}
	
	@GetMapping("/all")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId)
	{
		return customerService.getCustomerById(customerId);
	}
	
	@PutMapping("/{customerId}")
	public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer)
	{
		return customerService.updateCustomer(customerId, customer);
	}
	
	@DeleteMapping("/{customerId}")
	public String deleteCustomer(@PathVariable int customerId)
	{
		return customerService.deleteCustomer(customerId);
	}
}
