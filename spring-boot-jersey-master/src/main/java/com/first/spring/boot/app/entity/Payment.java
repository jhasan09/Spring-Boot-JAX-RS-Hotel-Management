package com.first.spring.boot.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    @Positive
    @NotNull(message = "Amount can't be null.")
    private double amount;

    @Column(name = "payment_date")
    @NotNull(message = "Payment Date can't be null.")
    @NotEmpty(message = "Payment Date can't be empty.")
    private String paymentDate;

    @Column(name = "payment_method")
    @NotNull(message = "Payment Method can't be null.")
    @NotEmpty(message = "Payment Method can't be empty.")
    private String paymentMethod;

    @Column(name = "customer_id")
    private Integer customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}