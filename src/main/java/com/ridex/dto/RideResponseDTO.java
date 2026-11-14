
package com.ridex.dto;

public class RideResponseDTO
{
    private int rideId;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double estimatedFare;
    private String rideStatus;

    private int customerId;
    private String customerName;

    private int driverId;
    private String driverName;

    public RideResponseDTO(int rideId, String pickupLocation,
            String dropLocation, double distance, double estimatedFare,
            String rideStatus, int customerId, String customerName,
            int driverId, String driverName)
    {
        this.rideId = rideId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distance = distance;
        this.estimatedFare = estimatedFare;
        this.rideStatus = rideStatus;
        this.customerId = customerId;
        this.customerName = customerName;
        this.driverId = driverId;
        this.driverName = driverName;
    }

    public int getRideId() {
        return rideId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public double getDistance() {
        return distance;
    }

    public double getEstimatedFare() {
        return estimatedFare;
    }

    public String getRideStatus() {
        return rideStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }
}