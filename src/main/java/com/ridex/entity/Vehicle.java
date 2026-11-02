package com.ridex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;
	private String vehicleNumber;
	private String vehicleType;
	private String vehicleModel;
	private String color;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String vehicleName, String vehicleNumber, String vehicleTypel, String vehicleModel, String color,
			Driver driver) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.color = color;
		this.driver = driver;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleTypel(String vehicleTypel) {
		this.vehicleType = vehicleTypel;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber
				+ ", vehicleTypel=" + vehicleType + ", vehicleModel=" + vehicleModel + ", color=" + color + ", driver="
				+ driver + "]";
	}
}
