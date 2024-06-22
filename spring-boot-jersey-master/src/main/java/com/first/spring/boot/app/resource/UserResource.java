package com.first.spring.boot.app.resource;

import com.first.spring.boot.app.dao.HotelBookingDAO;
import com.first.spring.boot.app.entity.*;
import com.first.spring.boot.app.logger.CustomLogger;
import com.first.spring.boot.app.response.booking.*;
import com.first.spring.boot.app.response.customer.*;
import com.first.spring.boot.app.response.hotel.ApiHotelResponse;
import com.first.spring.boot.app.response.hotel.HotelRoom;
import com.first.spring.boot.app.response.payment.*;
import com.first.spring.boot.app.response.room.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class UserResource {
    @Autowired
    private CustomLogger customLogger;

    @Autowired
    private HotelBookingDAO hotelBookingDAO;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/createcustomer")
    @ResponseBody
    public Response createCustomer(@Valid Customer customer) {
        customLogger.logRequest("GET", "/api/createcustomer " + "id: " + customer.getId());

        if (customer.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Id Field is missing.").build();
        }

        hotelBookingDAO.createCustomer(customer);
        String message = "Customer created successfully.";
        customLogger.logResponse("GET", "/api/createcustomer", 200);
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/createhotel")
    @ResponseBody
    public Response createHotel(@Valid Hotel hotel) {
        customLogger.logRequest("GET", "/api/createhotel " + "id: " + hotel.getId());

        if (hotel.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Id Field is missing.").build();
        }

        hotelBookingDAO.createHotel(hotel);
        String message = "Hotel created successfully.";
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/createroom")
    @ResponseBody
    public Response createRoom(@Valid Room room) {
        customLogger.logRequest("GET", "/api/createroom " + "id: " + room.getId());

        if (room.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Id Field is missing.").build();
        }

        hotelBookingDAO.createRoom(room);
        String message = "Hotel created successfully.";
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/createpayment")
    @ResponseBody
    public Response createPayment(@Valid Payment payment) {
        customLogger.logRequest("GET", "/api/createpayment " + "id: " + payment.getId());

        if (payment.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Id Field is missing.").build();
        }

        hotelBookingDAO.createPayment(payment);
        String message = "Payment created successfully.";
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/createbooking")
    @ResponseBody
    public Response createBooking(@Valid Booking booking) {
        customLogger.logRequest("GET", "/api/createpayment " + "id: " + booking.getId());

        if (booking.getId() == 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Id Field is missing.").build();
        }

        hotelBookingDAO.createBooking(booking);
        String message = "Booking created successfully.";
        return Response.status(Response.Status.OK).entity(message).build();
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/getcustomer/{id}")
    @ResponseBody
    public Response getCustomerById(@PathParam("id") int id) {
        Customer customer = hotelBookingDAO.getCustomer(id);
        if (customer == null) {
            String message = "No record found.";
            return Response.status(Response.Status.OK).entity(message).build();
        }

        List<CustomerBooking> bookings = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);

        List<Booking> bookingsList = hotelBookingDAO.getBookingByCustomerId(ids);

        bookingsList.forEach(booking -> {
            CustomerBooking jBooking = new CustomerBooking();
            jBooking.setId(booking.getId());
            jBooking.setStartDate(booking.getStartDate());
            jBooking.setEndDate(booking.getEndDate());

            CustomerRoom jRoom = new CustomerRoom();
            Room room = hotelBookingDAO.getRoom(booking.getRoomId());
            jRoom.setId(room.getId());
            jRoom.setRoomNumber(room.getRoomNumber());
            jRoom.setType(room.getType());

            CustomerHotel jHotel = new CustomerHotel();
            Hotel hotel = hotelBookingDAO.getHotel(room.getHotelId());

            jHotel.setId(hotel.getId());
            jHotel.setName(hotel.getName());
            jHotel.setAddress(hotel.getAddress());

            CustomerPayment jPayment = new CustomerPayment();
            Payment payment = hotelBookingDAO.getPayment(booking.getPaymentId());

            jPayment.setId(payment.getId());
            jPayment.setAmount(payment.getAmount());
            jPayment.setPaymentDate(payment.getPaymentDate());
            jPayment.setPaymentMethod(payment.getPaymentMethod());

            jRoom.setHotel(jHotel);
            jBooking.setRoom(jRoom);
            jBooking.setPayment(jPayment);
            bookings.add(jBooking);
        });

        ApiCustomerResponse jCustomer = new ApiCustomerResponse();
        jCustomer.setId(customer.getId());
        jCustomer.setName(customer.getName());
        jCustomer.setEmail(customer.getEmail());
        jCustomer.setBookings(bookings);

        return Response.status(Response.Status.OK).entity(jCustomer).build();
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/gethotel/{id}")
    @ResponseBody
    public Response getHotelById(@PathParam("id") int id) {
        Hotel hotel = hotelBookingDAO.getHotel(id);

        if (hotel == null) {
            String message = "No record found.";
            return Response.status(Response.Status.OK).entity(message).build();
        }

        List<HotelRoom> jRooms = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        List<Room> rooms = hotelBookingDAO.getRoomByHotelId(ids);

        rooms.forEach(room -> {
            HotelRoom jRoom = new HotelRoom();
            jRoom.setId(room.getId());
            jRoom.setRoomNumber(room.getRoomNumber());
            jRoom.setType(room.getType());
            jRooms.add(jRoom);
        });

        ApiHotelResponse jHotel = new ApiHotelResponse();
        jHotel.setId(hotel.getId());
        jHotel.setName(hotel.getName());
        jHotel.setAddress(hotel.getAddress());
        jHotel.setRooms(jRooms);

        return Response.status(Response.Status.OK).entity(jHotel).build();
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/getroom/{id}")
    @ResponseBody
    public Response getRoomById(@PathParam("id") int id) {
        Room room = hotelBookingDAO.getRoom(id);

        if (room == null) {
            String message = "No record found.";
            return Response.status(Response.Status.OK).entity(message).build();
        }

        List<RoomBooking> bookings = new ArrayList<>();

        RoomHotel jHotel = new RoomHotel();
        Hotel hotel = hotelBookingDAO.getHotel(room.getHotelId());
        jHotel.setId(hotel.getId());
        jHotel.setName(hotel.getName());
        jHotel.setAddress(hotel.getAddress());


        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        List<Booking> bookingsList = hotelBookingDAO.getBookingByRoomId(ids);

        bookingsList.forEach(booking -> {
            RoomBooking jBooking = new RoomBooking();
            jBooking.setId(booking.getId());
            jBooking.setStartDate(booking.getStartDate());
            jBooking.setEndDate(booking.getEndDate());

            RoomCustomer jCustomer = new RoomCustomer();
            Customer customer = hotelBookingDAO.getCustomer(booking.getCustomerId());
            jCustomer.setId(customer.getId());
            jCustomer.setName(customer.getName());
            jCustomer.setEmail(customer.getEmail());

            RoomPayment jPayment = new RoomPayment();
            Payment payment = hotelBookingDAO.getPayment(booking.getPaymentId());
            jPayment.setId(payment.getId());
            jPayment.setAmount(payment.getAmount());
            jPayment.setPaymentDate(payment.getPaymentDate());
            jPayment.setPaymentMethod(payment.getPaymentMethod());

            jBooking.setCustomer(jCustomer);
            jBooking.setPayment(jPayment);
            bookings.add(jBooking);
        });

        ApiRoomResponse jRoom = new ApiRoomResponse();
        jRoom.setId(room.getId());
        jRoom.setRoomNumber(room.getRoomNumber());
        jRoom.setType(room.getType());
        jRoom.setHotel(jHotel);
        jRoom.setBookings(bookings);

        return Response.status(Response.Status.OK).entity(jRoom).build();
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @ResponseBody
    @Path("/getpayment/{id}")
    public Response getPaymentById(@PathParam("id") int id) {
        Payment payment = hotelBookingDAO.getPayment(id);

        if (payment == null) {
            String message = "No record found.";
            return Response.status(Response.Status.OK).entity(message).build();
        }

        PaymentCustomer jCustomer = new PaymentCustomer();
        Customer customer = hotelBookingDAO.getCustomer(payment.getCustomerId());
        jCustomer.setId(customer.getId());
        jCustomer.setName(customer.getName());
        jCustomer.setEmail(customer.getEmail());

        PaymentBooking jBooking = null;
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        List<Booking> bookingsList = hotelBookingDAO.getBookingByPaymentId(ids);
        if (bookingsList.size() > 0) {
            Booking booking = bookingsList.get(0);
            PaymentHotel jHotel = new PaymentHotel();
            Room room = hotelBookingDAO.getRoom(booking.getRoomId());
            Hotel hotel = hotelBookingDAO.getHotel(room.getHotelId());

            jHotel.setId(hotel.getId());
            jHotel.setName(hotel.getName());
            jHotel.setAddress(hotel.getAddress());

            PaymentRoom jRoom = new PaymentRoom();
            jRoom.setId(room.getId());
            jRoom.setRoomNumber(room.getRoomNumber());
            jRoom.setType(room.getType());
            jRoom.setHotel(jHotel);

            jBooking = new PaymentBooking();
            jBooking.setId(booking.getId());
            jBooking.setStartDate(booking.getStartDate());
            jBooking.setEndDate(booking.getEndDate());
            jBooking.setRoom(jRoom);
        }

        ApiPaymentResponse jPayment = new ApiPaymentResponse();
        jPayment.setId(payment.getId());
        jPayment.setAmount(payment.getAmount());
        jPayment.setPaymentDate(payment.getPaymentDate());
        jPayment.setPaymentMethod(payment.getPaymentMethod());
        jPayment.setCustomer(jCustomer);
        jPayment.setBooking(jBooking);

        return Response.status(Response.Status.OK).entity(jPayment).build();

    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/getbooking/{id}")
    @ResponseBody
    public Response getBookingById(@PathParam("id") int id) {
        Booking booking = hotelBookingDAO.getBooking(id);

        if (booking == null) {
            String message = "No record found.";
            return Response.status(Response.Status.OK).entity(message).build();
        }

        BookingCustomer jCustomer = new BookingCustomer();
        Customer customer = hotelBookingDAO.getCustomer(booking.getCustomerId());
        jCustomer.setId(customer.getId());
        jCustomer.setName(customer.getName());
        jCustomer.setEmail(customer.getEmail());

        BookingHotel jHotel = new BookingHotel();
        Room room = hotelBookingDAO.getRoom(booking.getRoomId());
        Hotel hotel = hotelBookingDAO.getHotel(room.getHotelId());

        jHotel.setId(hotel.getId());
        jHotel.setName(hotel.getName());
        jHotel.setAddress(hotel.getAddress());

        BookingRoom jRoom = new BookingRoom();
        jRoom.setId(room.getId());
        jRoom.setRoomNumber(room.getRoomNumber());
        jRoom.setType(room.getType());
        jRoom.setHotel(jHotel);

        BookingPayment jPayment = new BookingPayment();
        Payment payment = hotelBookingDAO.getPayment(booking.getPaymentId());
        jPayment.setId(payment.getId());
        jPayment.setAmount(payment.getAmount());
        jPayment.setPaymentDate(payment.getPaymentDate());
        jPayment.setPaymentMethod(payment.getPaymentMethod());

        ApiBookingResponse jBooking = new ApiBookingResponse();
        jBooking.setId(booking.getId());
        jBooking.setStartDate(booking.getStartDate());
        jBooking.setEndDate(booking.getEndDate());
        jBooking.setCustomer(jCustomer);
        jBooking.setRoom(jRoom);
        jBooking.setPayment(jPayment);

        return Response.status(Response.Status.OK).entity(jBooking).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/updatecustomer")
    @ResponseBody
    public Response updateCustomer(@Valid Customer data) {
        String message = "";
        Customer customer = hotelBookingDAO.getCustomer(data.getId());
        if (customer != null) {
            customer.setName(data.getName());
            customer.setEmail(data.getEmail());
            hotelBookingDAO.createCustomer(customer);
            message = "Customer updated successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/updatehotel")
    @ResponseBody
    public Response updateHotel(@Valid Hotel data) {
        String message = "";
        Hotel hotel = hotelBookingDAO.getHotel(data.getId());
        if (hotel != null) {
            hotel.setName(data.getName());
            hotel.setAddress(data.getAddress());
            hotelBookingDAO.createHotel(hotel);
            message = "Hotel updated successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/updateroom")
    @ResponseBody
    public Response updateRoom(@Valid Room data) {
        String message = "";
        Room room = hotelBookingDAO.getRoom(data.getId());
        if (room != null) {
            room.setRoomNumber(data.getRoomNumber());
            room.setType(data.getType());
            room.setHotelId(data.getHotelId());
            hotelBookingDAO.createRoom(room);
            message = "Room updated successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/updatepayment")
    @ResponseBody
    public Response updatePayment(@Valid Payment data) {
        String message = "";
        Payment payment = hotelBookingDAO.getPayment(data.getId());
        if (payment != null) {
            payment.setAmount(data.getAmount());
            payment.setPaymentDate(data.getPaymentDate());
            payment.setPaymentMethod(data.getPaymentMethod());
            payment.setCustomerId(data.getCustomerId());
            hotelBookingDAO.createPayment(payment);
            message = "Payment updated successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/updatebooking")
    @ResponseBody
    public Response updateBooking(@Valid Booking data) {
        String message = "";
        Booking booking = hotelBookingDAO.getBooking(data.getId());
        if (booking != null) {
            booking.setStartDate(data.getStartDate());
            booking.setEndDate(data.getEndDate());
            booking.setCustomerId(data.getCustomerId());
            booking.setRoomId(data.getRoomId());
            booking.setPaymentId(data.getPaymentId());
            hotelBookingDAO.createBooking(booking);
            message = "Booking updated successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    @ResponseBody
    @Path("/deletecustomer/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        String message = "";
        Customer customer = hotelBookingDAO.getCustomer(id);
        if (customer != null) {
            hotelBookingDAO.deleteCustomer(customer);
            message = "Customer deleted successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    @ResponseBody
    @Path("/deleteroom/{id}")
    public Response deleteRoom(@PathParam("id") int id) {
        String message = "";
        Room room = hotelBookingDAO.getRoom(id);
        if (room != null) {
            hotelBookingDAO.deleteRoom(room);
            message = "Hotel deleted successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    @ResponseBody
    @Path("/deletehotel/{id}")
    public Response deleteHotel(@PathParam("id") int id) {
        String message = "";
        Hotel hotel = hotelBookingDAO.getHotel(id);
        if (hotel != null) {
            hotelBookingDAO.deleteHotel(hotel);
            message = "Hotel deleted successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    @ResponseBody
    @Path("/deletepayment/{id}")
    public Response deletePayment(@PathParam("id") int id) {
        String message = "";
        Payment payment = hotelBookingDAO.getPayment(id);
        if (payment != null) {
            hotelBookingDAO.deletePayment(payment);
            message = "Payment deleted successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

    @DELETE
    @Consumes("application/json")
    @Produces("application/json")
    @ResponseBody
    @Path("/deletebooking/{id}")
    public Response deleteBooking(@PathParam("id") int id) {
        String message = "";
        Booking booking = hotelBookingDAO.getBooking(id);
        if (booking != null) {
            hotelBookingDAO.deleteBooking(booking);
            message = "Booking deleted successfully.";
        } else {
            message = "No Record Found.";
        }

        return Response.status(Response.Status.OK).entity(message).build();
    }

}
