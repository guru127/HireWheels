package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.VehicleDetailsNotFoundException;

import java.util.List;

public interface VehicleService  {
    public List<Vehicle> getAllVehicles();
    public  List<Vehicle> getAvailableVehicles(Booking booking) throws VehicleDetailsNotFoundException;
    Vehicle getVehicleById(int id) throws VehicleDetailsNotFoundException;
}
