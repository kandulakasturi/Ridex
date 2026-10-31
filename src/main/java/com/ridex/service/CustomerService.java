package com.ridex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridex.entity.Customer;
import com.ridex.repository.CustomerRepository;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer registerCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(int customerId)
	{
		return customerRepository.findById(customerId).orElse(null);
	}
	
	public Customer updateCustomer(int customerId, Customer customer)
	{
		Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
		
		if(existingCustomer != null)
		{
			existingCustomer.setName(customer.getName());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setPassword(customer.getPassword());
			existingCustomer.setPhoneNumber(customer.getPhoneNumber());
			
			return customerRepository.save(existingCustomer);
		}
		
		return null;
	}
	
	public String deleteCustomer(int customerId)
	{
		if(customerRepository.existsById(customerId))
		{
			customerRepository.deleteById(customerId);
			
			return "Customer Deleted Successfully";
		}
		return "Customer Not Found";
	}
}
