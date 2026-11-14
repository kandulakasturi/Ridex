
package com.ridex.dto;

public class DriverResponseDTO
{
    private int driverId;
    private String name;
    private String email;
    private String phoneNumber;
    private String licenseNumber;
    private String availabilityStatus;

    public DriverResponseDTO(int driverId, String name, String email,
            String phoneNumber, String licenseNumber, String availabilityStatus)
    {
        this.driverId = driverId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.availabilityStatus = availabilityStatus;
    }

    public int getDriverId()
    {
        return driverId;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getLicenseNumber()
    {
        return licenseNumber;
    }

    public String getAvailabilityStatus()
    {
        return availabilityStatus;
    }
}
