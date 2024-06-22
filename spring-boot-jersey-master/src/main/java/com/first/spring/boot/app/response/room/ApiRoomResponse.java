package com.first.spring.boot.app.response.room;

import java.util.List;

public class ApiRoomResponse {
    private int id;
    private String roomNumber;
    private String type;
    private RoomHotel hotel;
    private List<RoomBooking>bookings;

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

    public RoomHotel getHotel() {
        return hotel;
    }

    public void setHotel(RoomHotel hotel) {
        this.hotel = hotel;
    }

    public List<RoomBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<RoomBooking> bookings) {
        this.bookings = bookings;
    }
}


