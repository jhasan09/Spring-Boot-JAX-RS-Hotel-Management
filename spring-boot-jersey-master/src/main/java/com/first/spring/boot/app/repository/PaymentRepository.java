package com.first.spring.boot.app.repository;

import com.first.spring.boot.app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findById(int id);

}