
package com.ridex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ridex.dto.CustomerResponseDTO;
import com.ridex.dto.DriverResponseDTO;
import com.ridex.dto.PaymentResponseDTO;
import com.ridex.dto.RideResponseDTO;
import com.ridex.entity.Customer;
import com.ridex.entity.Driver;
import com.ridex.entity.Payment;
import com.ridex.entity.Ride;
import com.ridex.repository.CustomerRepository;
import com.ridex.repository.DriverRepo;
import com.ridex.repository.PaymentRepository;
import com.ridex.repository.RideRepository;

@Service
public class AdminService
{
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private RideRepository rideRepository;
    
    @Autowired
    private PaymentRepository paymentRepository;
    

    public Page<CustomerResponseDTO> getAllCustomers(int page, int size) 
    {
    	Pageable pageable = PageRequest.of(
    			page,
    			size,
    			Sort.by("customerId").ascending()
    			);

    	Page<Customer> customers =
    			customerRepository.findAll(pageable);

    	return customers.map(customer ->
    		new CustomerResponseDTO(
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getPhoneNumber()
    				)
    			);
    }

    
    public Page<Driver> getAllDrivers(int page, int size, String sortBy, String direction)
    {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return driverRepo.findAll(pageable);
    }
    
    public Page<Ride> getAllRides(int page, int size, String sortBy, String direction)
    {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return rideRepository.findAll(pageable);
    }
    
    public Page<Payment> getAllPayments(int page, int size, String sortBy, String direction)
    {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return paymentRepository.findAll(pageable);
    }
}
