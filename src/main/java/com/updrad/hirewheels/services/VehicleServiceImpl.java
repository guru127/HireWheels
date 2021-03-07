package com.updrad.hirewheels.services;

import com.updrad.hirewheels.dao.VehicleDao;
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
}
