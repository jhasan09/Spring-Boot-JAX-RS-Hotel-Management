package com.first.spring.boot.app.response.booking;

public class ApiBookingResponse {
    private int id;
    private String startDate;
    private String endDate;
    private BookingCustomer customer;
    private BookingRoom room;
    private BookingPayment payment;

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

    public BookingCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(BookingCustomer customer) {
        this.customer = customer;
    }

    public BookingRoom getRoom() {
        return room;
    }

    public void setRoom(BookingRoom room) {
        this.room = room;
    }

    public BookingPayment getPayment() {
        return payment;
    }

    public void setPayment(BookingPayment payment) {
        this.payment = payment;
    }
}

