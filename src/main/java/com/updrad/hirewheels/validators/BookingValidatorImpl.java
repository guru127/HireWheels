package com.updrad.hirewheels.validators;

import com.updrad.hirewheels.dto.BookingDTO;
import com.updrad.hirewheels.entities.Location;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.APIException;
import com.updrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.updrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.updrad.hirewheels.services.UsersService;
import com.updrad.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookingValidatorImpl implements BookingValidator {

    @Autowired
    public VehicleService vehicleService;
    @Autowired
    public UsersService usersService;

    @Override
    public void validateBooking(BookingDTO bookingDTO) throws APIException, VehicleDetailsNotFoundException, UserDetailsNotFoundException {
        if(bookingDTO.getUsersId()<=0) {
            throw new APIException("Invalid user");
        }
        if (!bookingDTO.getBookingDate().isEqual(bookingDTO.getPickupDate().toLocalDate())){
        //if (!bookingDTO.getBookingDate().isEqual(bookingDTO.getPickupDate().getDayOfYear())){
           throw  new APIException("Booking date should be today's date");
        }
        Users users= usersService.getUserByID(bookingDTO.getUsersId());
        if(users.getWalletMoney()<bookingDTO.getAmount()) {
            throw new APIException("Insufficient balance. Please check with Admin’");
        }

        Vehicle vehicle= vehicleService.getVehicleById(bookingDTO.getVehicleId());
        if (!vehicle.isAvailabilityStatus()){
            throw new APIException("vehicle is unavailable for booking");
        }
        if (bookingDTO.getLocationId() != bookingDTO.getLocationId()){
            throw new APIException(" vehicle not available for booking location");
        }
    }
}
