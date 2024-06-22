package com.first.spring.boot.app.response.booking;

public class BookingRoom {
    private int id;
    private String roomNumber;
    private String type;
    private BookingHotel hotel;

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

    public BookingHotel getHotel() {
        return hotel;
    }

    public void setHotel(BookingHotel hotel) {
        this.hotel = hotel;
    }
}


