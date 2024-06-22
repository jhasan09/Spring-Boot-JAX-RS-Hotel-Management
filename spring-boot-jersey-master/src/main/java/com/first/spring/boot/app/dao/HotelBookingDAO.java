package com.first.spring.boot.app.dao;

import com.first.spring.boot.app.entity.*;
import com.first.spring.boot.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelBookingDAO {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void createRoom(Room room) {
        roomRepository.save(room);
    }

    public void createPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id);
    }

    public Hotel getHotel(int id) {
        return hotelRepository.findById(id);
    }

    public Room getRoom(int id) {
        return roomRepository.findById(id);
    }

    public Payment getPayment(int id) {
        return paymentRepository.findById(id);
    }

    public Booking getBooking(int id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingByCustomerId(List<Integer> ids) {
        return bookingRepository.findAllByCustomerIdIn(ids);
    }

    public List<Booking> getBookingByRoomId(List<Integer> ids) {
        return bookingRepository.findAllByRoomIdIn(ids);
    }

    public List<Booking> getBookingByPaymentId(List<Integer> ids) {
        return bookingRepository.findAllByPaymentIdIn(ids);
    }


    public List<Room> getRoomByHotelId(List<Integer> ids) {
        return roomRepository.findAllByHotelIdIn(ids);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public void deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    public void deletePayment(Payment payment) {
        paymentRepository.delete(payment);
    }

    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }
}
