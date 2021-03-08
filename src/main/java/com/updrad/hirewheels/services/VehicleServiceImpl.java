package com.updrad.hirewheels.services;

import com.updrad.hirewheels.dao.VehicleDao;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    public  VehicleDao vehicleDao;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles(Booking booking) {
        List<Vehicle> vehicleList= vehicleDao.findAll();
        List<Vehicle> vehicles=null;
        for (Vehicle v : vehicleList){
            if (v.getVehicleId()==booking.getVehicle().getVehicleId()
                    && v.isAvailabilityStatus() == true
                    && v.getLocation() == booking.getLocation() ){
                vehicles.add(v);
            }
        }
        return vehicles;
    }
}
