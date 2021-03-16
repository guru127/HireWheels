package com.updrad.hirewheels.services;

import com.updrad.hirewheels.dao.BookingDao;
import com.updrad.hirewheels.dao.VehicleDao;
import com.updrad.hirewheels.dao.VehicleSubCategoryDao;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    public  VehicleDao vehicleDao;
    @Autowired
    public  BookingDao bookingDao;


    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public List<Vehicle> getAvailableVehicles(Booking booking) throws VehicleDetailsNotFoundException {
        List<Vehicle> vehicleList= vehicleDao.findAll();
        List<Vehicle> vehicles=new ArrayList<>();
        for (Vehicle vehicle : vehicleList){
            if (vehicle.getVehicleId()==booking.getVehicle().getVehicleId()
                    && vehicle.isAvailabilityStatus()
                    && vehicle.getLocation().getLocationId() == booking.getLocation().getLocationId() ){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public Vehicle getVehicleById(int id) throws VehicleDetailsNotFoundException {
        return vehicleDao.findById(id).get();
    }

    public List<Vehicle> getAvailableVehicle(int categoryId, LocalDateTime pickUpDate, LocalDateTime dropDate, int locationId) {
        List<Vehicle> vehicles = vehicleDao.findAll();
        List<Vehicle> vehicleList = new ArrayList<>();
        List<Booking> bookingList = bookingDao.findAll();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleSubcategory().getVehicleSubCategoryId() == categoryId
                    && vehicle.getLocation().getLocationId() == locationId && vehicle.isAvailabilityStatus()==true){
                for (Booking booking : bookingList) {
                    if (booking.getVehicle().getVehicleId() == vehicle.getVehicleId()
                            && (booking.getPickupDate().isEqual(pickUpDate) || booking.getDropoffDate().isEqual(dropDate))) {
                    }
                }
                vehicleList.add(vehicle);
            }
        }
        return vehicleList;
    }
}
