
package com.ridex.dto;

public class PaymentResponseDTO
{
    private int paymentId;
    private int rideId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public PaymentResponseDTO(int paymentId, int rideId,
            double amount, String paymentMethod, String paymentStatus)
    {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId()
    {
        return paymentId;
    }

    public int getRideId()
    {
        return rideId;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    public String getPaymentStatus()
    {
        return paymentStatus;
    }
}
