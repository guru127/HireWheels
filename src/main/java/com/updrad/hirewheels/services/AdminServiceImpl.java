package com.updrad.hirewheels.services;
import com.updrad.hirewheels.dao.VehicleDao;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.VehicleRegistrationFailedException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    public VehicleDao vehicleDao;
    @Override
    public Vehicle registerVehicle(Vehicle vehicle ) throws VehicleRegistrationFailedException {
        if (!vehicle.isAvailabilityStatus()){
            vehicle.setAvailabilityStatus(true);
        }
        return vehicleDao.save(vehicle);
    }

    @Override
    public Vehicle changeAvailability(Vehicle vehicle) {
        vehicle.setAvailabilityStatus(false);
        return vehicleDao.save(vehicle);
    }
}
