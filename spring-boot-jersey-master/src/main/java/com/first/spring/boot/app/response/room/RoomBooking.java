package com.first.spring.boot.app.response.room;

public class RoomBooking {
    private int id;
    private String startDate;
    private String endDate;
    private RoomCustomer customer;
    private RoomPayment payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public RoomCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(RoomCustomer customer) {
        this.customer = customer;
    }

    public RoomPayment getPayment() {
        return payment;
    }

    public void setPayment(RoomPayment payment) {
        this.payment = payment;
    }
}