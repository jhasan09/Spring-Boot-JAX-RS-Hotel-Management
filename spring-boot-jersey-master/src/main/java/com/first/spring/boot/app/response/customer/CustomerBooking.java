package com.first.spring.boot.app.response.customer;

public class CustomerBooking {
    private int id;
    private String startDate;
    private String endDate;
    private CustomerRoom room;
    private CustomerPayment payment;

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

    public CustomerRoom getRoom() {
        return room;
    }

    public void setRoom(CustomerRoom room) {
        this.room = room;
    }

    public CustomerPayment getPayment() {
        return payment;
    }

    public void setPayment(CustomerPayment payment) {
        this.payment = payment;
    }
}