package com.first.spring.boot.app.repository;

import com.first.spring.boot.app.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findById(int id);
    List<Room> findAllByHotelIdIn (List<Integer>ids);

}
