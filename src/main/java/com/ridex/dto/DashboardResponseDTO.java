package com.ridex.dto;

public class DashboardResponseDTO 
{
	private long totalCustomers;
	private long totalDrivers;
	private long totalRides;
	private long totalPayments;
	private long completedRides;
	private long cancelledRides;
	public long getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(long totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public long getTotalDrivers() {
		return totalDrivers;
	}
	public void setTotalDrivers(long totalDrivers) {
		this.totalDrivers = totalDrivers;
	}
	public long getTotalRides() {
		return totalRides;
	}
	public void setTotalRides(long totalRides) {
		this.totalRides = totalRides;
	}
	public long getTotalPayments() {
		return totalPayments;
	}
	public void setTotalPayments(long totalPayments) {
		this.totalPayments = totalPayments;
	}
	public long getCompletedRides() {
		return completedRides;
	}
	public void setCompletedRides(long completedRides) {
		this.completedRides = completedRides;
	}
	public long getCancelledRides() {
		return cancelledRides;
	}
	public void setCancelledRides(long cancelledRides) {
		this.cancelledRides = cancelledRides;
	}
	public DashboardResponseDTO(long totalCustomers, long totalDrivers, long totalRides, long totalPayments,
			long completedRides, long cancelledRides) {
		super();
		this.totalCustomers = totalCustomers;
		this.totalDrivers = totalDrivers;
		this.totalRides = totalRides;
		this.totalPayments = totalPayments;
		this.completedRides = completedRides;
		this.cancelledRides = cancelledRides;
	}
	public DashboardResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
