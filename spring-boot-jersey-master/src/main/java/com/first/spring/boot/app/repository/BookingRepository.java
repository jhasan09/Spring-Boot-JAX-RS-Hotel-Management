package com.first.spring.boot.app.repository;

import com.first.spring.boot.app.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findById(int id);
    List<Booking> findAllByCustomerIdIn(List<Integer>ids);
    List<Booking> findAllByRoomIdIn(List<Integer>ids);
    List<Booking> findAllByPaymentIdIn (List<Integer>ids);

}
