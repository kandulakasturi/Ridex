package com.ridex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ridex.dto.CustomerResponseDTO;
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
	
//	public Customer updateCustomer(int customerId, Customer customer)
//	{
//		Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
//		
//		if(existingCustomer != null)
//		{
//			existingCustomer.setName(customer.getName());
//			existingCustomer.setEmail(customer.getEmail());
//			existingCustomer.setPassword(customer.getPassword());
//			existingCustomer.setPhoneNumber(customer.getPhoneNumber());
//			
//			return customerRepository.save(existingCustomer);
//		}
//		
//		return null;
//	}
	
	public String deleteCustomer(int customerId)
	{
		if(customerRepository.existsById(customerId))
		{
			customerRepository.deleteById(customerId);
			
			return "Customer Deleted Successfully";
		}
		return "Customer Not Found";
	}
	
	public CustomerResponseDTO getCustomerProfile(int customerId)
	{
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));
		
		return new CustomerResponseDTO(customer.getCustomerId(),customer.getName(),customer.getEmail(),customer.getPhoneNumber());
	}
	
	public CustomerResponseDTO updateCustomer(int customerId,Customer updateCustomer)
	{
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));
		
		customer.setName(updateCustomer.getName());
		customer.setEmail(updateCustomer.getEmail());
		customer.setPhoneNumber(updateCustomer.getPhoneNumber());
		
		Customer savedCustomer = customerRepository.save(customer);
		
		return new CustomerResponseDTO(savedCustomer.getCustomerId(),
										savedCustomer.getName(),
										savedCustomer.getEmail(),
										savedCustomer.getPhoneNumber());
	}
}
