package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.VehicleRegistrationFailedException;

public interface AdminService {
    public Vehicle registerVehicle(Vehicle vehicle) throws VehicleRegistrationFailedException;
    public  Vehicle changeAvailability( Vehicle vehicle);

}
