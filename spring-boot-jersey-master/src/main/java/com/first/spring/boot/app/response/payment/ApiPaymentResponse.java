package com.first.spring.boot.app.response.payment;

public class ApiPaymentResponse {
    private int id;
    private double amount;
    private String paymentDate;
    private String paymentMethod;
    private PaymentCustomer customer;
    private PaymentBooking booking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(PaymentCustomer customer) {
        this.customer = customer;
    }

    public PaymentBooking getBooking() {
        return booking;
    }

    public void setBooking(PaymentBooking booking) {
        this.booking = booking;
    }
}

