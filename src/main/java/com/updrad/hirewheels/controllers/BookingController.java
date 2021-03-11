package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.BookingDTO;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/hirewheels/v1")
public class BookingController {
    @Autowired
    public BookingService bookingService;
    @Autowired
    public ModelMapper modelMapper;

    @PostMapping(value = "/bookings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newBooking(@RequestBody BookingDTO bookingDTO) throws Exception {
        Booking newBooking = modelMapper.map(bookingDTO, Booking.class);
        Booking savedBooking= bookingService.addBooking(newBooking, newBooking.getUsers());
        BookingDTO savedBookingDTO = modelMapper.map(savedBooking,BookingDTO.class);
        return new ResponseEntity<>(savedBookingDTO, HttpStatus.CREATED);

    }
}
