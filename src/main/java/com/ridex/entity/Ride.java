package com.ridex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ride 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rideId;
	private String pickupLocation;
	private String dropLocation;
	private double distance;
	private double estimatedFare;
	private String rideStatus;
	
	@ManyToOne
	@JoinColumn(name="cutsomer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;

	public Ride() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ride(String pickupLocation, String dropLocation, double distance,
			String rideStatus, Customer customer, Driver driver) {
		super();
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.distance = distance;
		this.rideStatus = rideStatus;
		this.customer = customer;
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation
				+ ", distance=" + distance + ", estimatedFare=" + estimatedFare + ", rideStatus=" + rideStatus
				+ ", customer=" + customer + ", driver=" + driver + "]";
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getEstimatedFare() {
		return estimatedFare;
	}

	public void setEstimatedFare(double estimatedFare) {
		this.estimatedFare = estimatedFare;
	}

	public String getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(String rideStatus) {
		this.rideStatus = rideStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
}
