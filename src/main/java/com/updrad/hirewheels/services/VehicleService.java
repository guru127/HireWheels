package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Vehicle;

import java.util.List;

public interface VehicleService  {
    public List<Vehicle> getAllVehicles();
    public  List<Vehicle> getAvailableVehicles(Booking booking);
}
