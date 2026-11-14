
package com.ridex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.dto.CustomerResponseDTO;
import com.ridex.dto.DriverResponseDTO;
import com.ridex.dto.PaymentResponseDTO;
import com.ridex.dto.RideResponseDTO;
import com.ridex.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminService adminService;

    @GetMapping("/customers")
    public List<CustomerResponseDTO> getAllCustomers()
    {
        return adminService.getAllCustomers();
    }
    
    @GetMapping("/drivers")
    public List<DriverResponseDTO> getAllDrivers()
    {
        return adminService.getAllDrivers();
    }
   
    @GetMapping("/rides")
    public List<RideResponseDTO> getAllRides()
    {
        return adminService.getAllRides();
    }
    
    @GetMapping("/payments")
    public List<PaymentResponseDTO> getAllPayments()
    {
        return adminService.getAllPayments();
    }
}
