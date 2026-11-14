
package com.ridex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<CustomerResponseDTO> getAllCustomers()
    {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponseDTO> customerList = new ArrayList<>();

        for(Customer customer : customers)
        {
            CustomerResponseDTO dto = new CustomerResponseDTO(
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getPhoneNumber()
            );

            customerList.add(dto);
        }

        return customerList;
    }
    
    public List<DriverResponseDTO> getAllDrivers()
    {
        List<Driver> drivers = driverRepo.findAll();

        List<DriverResponseDTO> driverList = new ArrayList<>();

        for(Driver driver : drivers)
        {
            DriverResponseDTO dto = new DriverResponseDTO(
                    driver.getDriverId(),
                    driver.getName(),
                    driver.getEmail(),
                    driver.getPhoneNumber(),
                    driver.getLicenseNumber(),
                    driver.getAvailabilityStatus()
            );

            driverList.add(dto);
        }

        return driverList;
    }
    
    public List<RideResponseDTO> getAllRides()
    {
        List<Ride> rides = rideRepository.findAll();

        List<RideResponseDTO> rideList = new ArrayList<>();

        for(Ride ride : rides)
        {
            int customerId = ride.getCustomer().getCustomerId();
            String customerName = ride.getCustomer().getName();

            int driverId = 0;
            String driverName = null;

            if(ride.getDriver() != null)
            {
                driverId = ride.getDriver().getDriverId();
                driverName = ride.getDriver().getName();
            }

            RideResponseDTO dto = new RideResponseDTO(
                    ride.getRideId(),
                    ride.getPickupLocation(),
                    ride.getDropLocation(),
                    ride.getDistance(),
                    ride.getEstimatedFare(),
                    ride.getRideStatus(),
                    customerId,
                    customerName,
                    driverId,
                    driverName
            );

            rideList.add(dto);
        }

        return rideList;
    }
    
    public List<PaymentResponseDTO> getAllPayments()
    {
        List<Payment> payments = paymentRepository.findAll();

        List<PaymentResponseDTO> paymentList = new ArrayList<>();

        for(Payment payment : payments)
        {
            int rideId = 0;

            if(payment.getRide() != null)
            {
                rideId = payment.getRide().getRideId();
            }

            PaymentResponseDTO dto = new PaymentResponseDTO(
                    payment.getPaymentId(),
                    rideId,
                    payment.getAmount(),
                    payment.getPaymentMethod(),
                    payment.getPaymentStatus()
            );

            paymentList.add(dto);
        }

        return paymentList;
    }
}
