package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.entities.Vehicle;

public interface AdminService {
    public Vehicle registerVehicle(Vehicle vehicle);
    public  Vehicle changeAvailability( Vehicle vehicle);

}
