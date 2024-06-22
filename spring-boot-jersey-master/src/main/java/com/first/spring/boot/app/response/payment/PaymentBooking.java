package com.first.spring.boot.app.response.payment;

public class PaymentBooking {
    private int id;
    private String startDate;
    private String endDate;
    private PaymentRoom room;

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

    public PaymentRoom getRoom() {
        return room;
    }

    public void setRoom(PaymentRoom room) {
        this.room = room;
    }
}