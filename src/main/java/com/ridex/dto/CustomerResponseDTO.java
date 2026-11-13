package com.ridex.dto;

public class CustomerResponseDTO 
{
	 private int customerId;
	    private String name;
	    private String email;
	    private String phoneNumber;

	    public CustomerResponseDTO(int customerId, String name, String email, String phoneNumber) {
	        this.customerId = customerId;
	        this.name = name;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	    }

	    public int getCustomerId() {
	        return customerId;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
}
