package com.updrad.hirewheels.services;
import com.updrad.hirewheels.dao.*;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.entities.VehicleSubCategory;
import com.updrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.updrad.hirewheels.exceptions.VehicleRegistrationFailedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
public class VehicleServiceTest {
    @Mock
    private VehicleDao vehicleDao;
    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Autowired
    public AdminService adminService;
    @Autowired
    public VehicleSubCategoryDao vehicleSubCategoryDao;
    @Autowired
    public FuelTypeDao fuelTypeDao;
    @Autowired
    public LocationDao locationDao;
    @Autowired
    public UsersDao usersDao;
   @Autowired
   public InitService initService;

    @Test
    public  void  tastGetAllVehicles() throws VehicleRegistrationFailedException {

        Vehicle vehicle= new Vehicle();
        vehicle.setVehicleModel("new");
        vehicle.setVehicleNumber("007");
        vehicle.setColor("red");
        vehicle.setAvailabilityStatus(true);
        vehicle.setVehicleImgUrl("image.url");
        vehicle.setVehicleSubcategory(vehicleSubCategoryDao.findById(8).get());
        vehicle.setFuelType(fuelTypeDao.findById(12).get());
        vehicle.setLocation(locationDao.findById(14).get());

        adminService.registerVehicle(vehicle);

        List<Vehicle> vehicles=vehicleService.getAllVehicles();
        Assertions.assertNotNull(vehicles);
    }
    @Test
    public  void  testGetAvailableVehicles() throws VehicleRegistrationFailedException, VehicleDetailsNotFoundException {
        initService.start();
        Vehicle vehicle= new Vehicle();
        vehicle.setVehicleModel("new");
        vehicle.setVehicleNumber("007");
        vehicle.setColor("red");
        vehicle.setAvailabilityStatus(true);
        vehicle.setVehicleImgUrl("image.url");
        vehicle.setVehicleSubcategory(vehicleSubCategoryDao.findById(8).get());
        vehicle.setFuelType(fuelTypeDao.findById(12).get());
        vehicle.setLocation(locationDao.findById(14).get());

        adminService.registerVehicle(vehicle);

        Booking booking= new Booking();
        booking.setBookingDate(LocalDateTime.now());
        booking.setPickupDate(LocalDateTime.now());
        booking.setDropoffDate(LocalDateTime.now());
        booking.setAmount(150);
        booking.setLocation(locationDao.findById(14).get());
        booking.setUsers(usersDao.findById(3).get());
        booking.setVehicle(vehicle);

        List<Vehicle> vehicles=vehicleService.getAvailableVehicles(booking);
        Assertions.assertNotNull(vehicles);

    }
}
