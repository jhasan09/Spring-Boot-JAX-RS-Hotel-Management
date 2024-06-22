package com.first.spring.boot.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "room_number", nullable = false)
    @NotNull(message = "Room Number can't be null.")
    @NotEmpty(message = "Room Number can't be empty.")
    private String roomNumber;

    @Column(name = "type")
    @NotNull(message = "Room Type can't be null.")
    @NotEmpty(message = "Room Type can't be empty.")
    private String type;

    @Column(name = "hotel_id")
    @NotNull(message = "Hotel Id can't be null.")
    private Integer hotelId;

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

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}


