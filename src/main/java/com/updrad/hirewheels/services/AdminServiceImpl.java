package com.updrad.hirewheels.services;

import com.updrad.hirewheels.HireWheelsApplication;
import com.updrad.hirewheels.dao.UsersDao;
import com.updrad.hirewheels.dao.VehicleDao;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    public VehicleDao vehicleDao;
    @Override
    public Vehicle registerVehicle(Vehicle vehicle ) {
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
