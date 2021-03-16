package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.BookingDTO;
import com.updrad.hirewheels.dto.ResponseDTO;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.BookingFailedException;
import com.updrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.updrad.hirewheels.services.BookingService;
import com.updrad.hirewheels.services.UsersService;
import com.updrad.hirewheels.validators.BookingValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;


@RestController
@RequestMapping(value = "/hirewheels/v1")
public class BookingController {
    @Autowired
    public BookingService bookingService;
    @Autowired
    public UsersService usersService;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public BookingValidator bookingValidator;

    @PostMapping(value = "/bookings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newBooking(@RequestBody BookingDTO bookingDTO) throws Exception {
        bookingValidator.validateBooking(bookingDTO);
        Booking newBooking = modelMapper.map(bookingDTO, Booking.class);

        Users users= usersService.getUserByID(bookingDTO.getUsersId());
        if (Objects.nonNull(users)){
            newBooking.setUsers(users);
        }else{
            throw new UserDetailsNotFoundException(" user not found for userId :"+bookingDTO.getUsersId());
        }
        Booking savedBooking= bookingService.addBooking(newBooking);
        BookingDTO savedBookingDTO = modelMapper.map(savedBooking,BookingDTO.class);
        if (Objects.nonNull(savedBooking)){
            ResponseDTO responseDTO= new ResponseDTO();
            responseDTO.setTimeStamp(LocalDateTime.now());
            responseDTO.setMessage("Booking successful");
            responseDTO.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
        }else{
            throw  new BookingFailedException("booking failed");
        }
    }
}