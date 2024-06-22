package com.first.spring.boot.app.response.payment;

public class PaymentRoom {
    private int id;
    private String roomNumber;
    private String type;
    private PaymentHotel hotel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaymentHotel getHotel() {
        return hotel;
    }

    public void setHotel(PaymentHotel hotel) {
        this.hotel = hotel;
    }
}


