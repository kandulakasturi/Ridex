package com.ridex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int driverId;
	private String name;
	private String email;
	@JsonIgnore
	private String password;
	private String phoneNumber;
	private String licenseNumber;
	private String availabilityStatus;
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(String name, String email, String password, String phoneNumber, String licenseNumber,
			String availabilityStatus) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.licenseNumber = licenseNumber;
		this.availabilityStatus = availabilityStatus;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", licenseNumber=" + licenseNumber + ", availabilityStatus="
				+ availabilityStatus + "]";
	}
	
	
}
