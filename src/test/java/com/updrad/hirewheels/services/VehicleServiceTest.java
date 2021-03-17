package com.updrad.hirewheels.services;
import com.updrad.hirewheels.dao.*;
import com.updrad.hirewheels.entities.*;
import com.updrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.updrad.hirewheels.exceptions.VehicleRegistrationFailedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class VehicleServiceTest {
    @Mock
    private VehicleDao vehicleDao;
    @Mock
    public BookingDao bookingDao;
    @Mock
    public LocationDao locationDao;
    @Mock
    public VehicleSubCategoryDao vehicleSubCategoryDao;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @BeforeEach
    private void setupMockito(){
        List<Vehicle> vehicles =new ArrayList<>();
        Vehicle vehicle1=new Vehicle(1,"vehicle1","ka15","black", true,"image.test.ka15.url",
                new VehicleSubCategory(1,"sub1",new VehicleCategory(1, "cat1"),
                        250),  new FuelType(1,"diesel"),new Location(1,"location1","address",407,new City()));

        Vehicle vehicle2= new Vehicle(2, "vehicle2", "KA14", "red",false, "image.test.ka15.url2",
                new VehicleSubCategory(1,"sub1",new VehicleCategory(1,"cat1"),
                        225),new FuelType(1,"diesel"),new Location(1,"location1", "address",407,new City()));

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        Mockito.when(vehicleDao.findAll()).thenReturn(vehicles);

        List<Booking> bookings = new ArrayList<>();

        Booking b1=new Booking(1,LocalDate.of(2020,02,02),
                LocalDateTime.of(2020,01, 01, 12,00,00),
                LocalDateTime.of(2020,01, 01, 12,00,00),
                300,new Location(), vehicle2, new Users());

        Booking b2=new Booking(2,LocalDate.of(2020,03,02),
                LocalDateTime.of(2020,02, 01, 12,00,00),
                LocalDateTime.of(2020,02, 01, 12,00,00),
                300,new Location(), vehicle2, new Users());
        bookings.add(b1);
        bookings.add(b2);
        Mockito.when(bookingDao.findAll()).thenReturn(bookings);
    }

    @Test
    public  void  tastGetAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        Assertions.assertNotNull(vehicles);
        Assertions.assertEquals(vehicles.size(), 2); // i have added two mock so checking size is 2 or not
    }
    @Test
    public  void  testGetAvailableVehicles()  {
        LocalDateTime pickupDate= LocalDateTime.of(2020,01, 01, 12,00,00);
        LocalDateTime dropofDate= LocalDateTime.of(2020,01, 02, 12,00,00);

        List<Vehicle> vehicles =vehicleService.getAvailableVehicle(1,pickupDate,dropofDate,1);
        Assertions.assertNotNull(vehicles);
        Assertions.assertEquals(vehicles.size(),1);  // out of two added vehicle added only one is available

    }
}
