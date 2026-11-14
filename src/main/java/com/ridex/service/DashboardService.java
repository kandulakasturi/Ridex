
package com.ridex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridex.dto.DashboardResponseDTO;
import com.ridex.repository.CustomerRepository;
import com.ridex.repository.DriverRepo;
import com.ridex.repository.RideRepository;
import com.ridex.repository.PaymentRepository;

@Service
public class DashboardService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public DashboardResponseDTO getDashboardStats() {

        long totalCustomers = customerRepository.count();

        long totalDrivers = driverRepo.count();

        long totalRides = rideRepository.count();

        long totalPayments = paymentRepository.count();

        long completedRides =
                rideRepository.countByRideStatus("COMPLETED");

        long cancelledRides =
                rideRepository.countByRideStatus("CANCELLED");

        return new DashboardResponseDTO(
                totalCustomers,
                totalDrivers,
                totalRides,
                totalPayments,
                completedRides,
                cancelledRides
        );
    }
}