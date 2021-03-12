package com.updrad.hirewheels.validators;

import com.updrad.hirewheels.dto.BookingDTO;
import com.updrad.hirewheels.exceptions.APIException;
import com.updrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.updrad.hirewheels.exceptions.VehicleDetailsNotFoundException;

public interface BookingValidator  {
    public void validateBooking(BookingDTO bookingDTO) throws APIException, VehicleDetailsNotFoundException, UserDetailsNotFoundException;
}
