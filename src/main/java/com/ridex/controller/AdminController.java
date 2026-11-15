
package com.ridex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.dto.CustomerResponseDTO;
import com.ridex.entity.Driver;
import com.ridex.entity.Payment;
import com.ridex.entity.Ride;
import com.ridex.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminService adminService;


    @GetMapping("/customers")
    public Page<CustomerResponseDTO> getAllCustomers(
    	@RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {

    return adminService.getAllCustomers(page, size);
    }
    
    @GetMapping("/drivers")
    public Page<Driver> getAllDrivers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "driverId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction)
    {
        return adminService.getAllDrivers(page, size, sortBy, direction);
    }
    
    @GetMapping("/rides")
    public Page<Ride> getAllRides(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "rideId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction)
    {
        return adminService.getAllRides(page, size, sortBy, direction);
    }
    
    @GetMapping("/payments")
    public Page<Payment> getAllPayments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "paymentId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction)
    {
        return adminService.getAllPayments(page, size, sortBy, direction);
    }
}
