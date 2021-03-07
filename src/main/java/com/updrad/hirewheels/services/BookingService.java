package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Users;
import org.apache.catalina.User;

public interface BookingService {
    public Booking addBooking (Booking booking, Users users) throws Exception;
}
