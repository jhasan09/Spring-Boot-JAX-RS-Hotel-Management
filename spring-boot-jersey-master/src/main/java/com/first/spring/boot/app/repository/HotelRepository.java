package com.first.spring.boot.app.repository;

import com.first.spring.boot.app.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
   Hotel findById(int id);
}
