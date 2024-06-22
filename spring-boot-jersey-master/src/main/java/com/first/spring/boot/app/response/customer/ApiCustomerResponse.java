package com.first.spring.boot.app.response.customer;

import java.util.List;

public class ApiCustomerResponse {
    private int id;
    private String name;
    private String email;
    private List<CustomerBooking> bookings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<CustomerBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<CustomerBooking> bookings) {
        this.bookings = bookings;
    }
}


