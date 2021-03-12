package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.VehicleRegistrationFailedException;
import com.updrad.hirewheels.exceptions.VehicleSatusException;

public interface AdminService {
    public Vehicle registerVehicle(Vehicle vehicle) throws VehicleRegistrationFailedException;
    public  Vehicle changeAvailability( Vehicle vehicle) throws VehicleSatusException;

}
