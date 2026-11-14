package com.ridex.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Driver 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int driverId;
	
	@NotBlank(message = "Driver name cannot be empty")
	@Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
	private String name;

	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Enter a valid email address")
	private String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotBlank(message = "Password cannot be empty")
	@Size(min = 6, message = "Password must contain at least 6 characters")
	private String password;

	@NotBlank(message = "Phone number cannot be empty")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter a valid 10-digit phone number")
	private String phoneNumber;

	@NotBlank(message = "License number cannot be empty")
	private String licenseNumber;

	@NotBlank(message = "Availability status cannot be empty")
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
