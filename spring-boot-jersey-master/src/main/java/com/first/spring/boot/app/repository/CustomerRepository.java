package com.first.spring.boot.app.repository;

import com.first.spring.boot.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int id);

}
