package com.updrad.hirewheels.services;

import com.updrad.hirewheels.dao.*;
import com.updrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    public RoleDao userRoleDao;
    @Autowired
    public UsersDao usersDao;
    @Autowired
    public VehicleCategoryDao vehicleCategoryDao;
    @Autowired
    public VehicleSubCategoryDao vehicleSubCategoryDao;
    @Autowired
    public CityDao cityDao;
    @Autowired
    public FuelTypeDao fuelTypeDao;
    @Autowired
    public LocationDao locationDao;
    //@Autowired
    //DTOEntityConveter dtoEntityConveter;
    
    @Override
    public void start() {
          addUserRole();
          addUser();
          addVehicleCategory();
          addVehicleSubCategory();
          addCity();
          addFuelType();
          addLocation();
    }

    private void addVehicleCategory() {
        VehicleCategory vehicleCategory1= new VehicleCategory();
        vehicleCategory1.setVehicleCategoryId(10);
        vehicleCategory1.setVehicleCategoryName("CAR");

        VehicleCategory vehicleCategory2= new VehicleCategory();
        vehicleCategory2.setVehicleCategoryId(11);
        vehicleCategory2.setVehicleCategoryName("BIKE");

        vehicleCategoryDao.saveAll(List.of(vehicleCategory1,vehicleCategory2));
    }

    private void addUser() {
        Users users1 = new Users();
        users1.setFirstName("Upgrad");
        users1.setLastName("Admin");
        users1.setPassword("admin@123");
        users1.setEmail("upgrad@gmail.com");
        users1.setMobileNo(9999999999l);
        users1.setWalletMoney(10000);
        users1.setRole(userRoleDao.findByRoleId(1));
        usersDao.save(users1);
    }

    private void addUserRole() {
        Role admin = new Role();
        admin.setRoleName("Admin");
         userRoleDao.save(admin);

        Role user = new Role();
        user.setRoleName("User");
         userRoleDao.save(user);
    }

    private void addVehicleSubCategory() {

    VehicleSubCategory vehicleSubCategory1= new VehicleSubCategory();
    vehicleSubCategory1.setVehicleSubCategoryId(1);
    vehicleSubCategory1.setVehicleSubCategoryName("SUV");
    vehicleSubCategory1.setPricePerDay(300);
    vehicleSubCategory1.setVehicleCategory(vehicleCategoryDao.findByVehicleCategoryId(4));

    VehicleSubCategory vehicleSubCategory2= new VehicleSubCategory();
    vehicleSubCategory2.setVehicleSubCategoryId(2);
    vehicleSubCategory2.setVehicleSubCategoryName("SEDAN");
    vehicleSubCategory2.setPricePerDay(350);
    vehicleSubCategory2.setVehicleCategory(vehicleCategoryDao.findByVehicleCategoryId(4));

    VehicleSubCategory vehicleSubCategory3= new VehicleSubCategory();
    vehicleSubCategory3.setVehicleSubCategoryId(3);
    vehicleSubCategory3.setVehicleSubCategoryName("HATCHBACK");
    vehicleSubCategory3.setPricePerDay(250);
    vehicleSubCategory3.setVehicleCategory(vehicleCategoryDao.findByVehicleCategoryId(4));

    VehicleSubCategory vehicleSubCategory4= new VehicleSubCategory();
    vehicleSubCategory4.setVehicleSubCategoryId(4);
    vehicleSubCategory4.setVehicleSubCategoryName("CRUISER");
    vehicleSubCategory4.setPricePerDay(200);
    vehicleSubCategory4.setVehicleCategory(vehicleCategoryDao.findByVehicleCategoryId(5));

    VehicleSubCategory vehicleSubCategory5= new VehicleSubCategory();
    vehicleSubCategory5.setVehicleSubCategoryId(5);
    vehicleSubCategory5.setVehicleSubCategoryName("DIRT BIKE");
    vehicleSubCategory5.setPricePerDay(200);
    vehicleSubCategory5.setVehicleCategory(vehicleCategoryDao.findByVehicleCategoryId(5));

    VehicleSubCategory vehicleSubCategory6= new VehicleSubCategory();
    vehicleSubCategory6.setVehicleSubCategoryId(6);
    vehicleSubCategory6.setVehicleSubCategoryName("SPORTS BIKE");
    vehicleSubCategory6.setPricePerDay(150);
    vehicleSubCategory6.setVehicleCategory(vehicleCategoryDao.findByVehicleCategoryId(5));


        vehicleSubCategoryDao.saveAll(List.of(vehicleSubCategory1, vehicleSubCategory2,
                vehicleSubCategory3,vehicleSubCategory4, vehicleSubCategory5,vehicleSubCategory6));
    }

    private void addCity() {
        City city = new City();
        city.setCityId(1);
        city.setCityName("Mumbai");
       cityDao.save(city);
    }

    private void addFuelType() {

        FuelType fuelType1= new FuelType();
        fuelType1.setFuelTypeId(1);
        fuelType1.setFuelType("Petrol");

        FuelType fuelType2 =new FuelType();
        fuelType2.setFuelTypeId(2);
        fuelType1.setFuelType("Diesel");

        fuelTypeDao.saveAll(List.of(fuelType1,fuelType2));;
    }

    private void addLocation() {

        Location location1=new Location();
        location1.setLocationId(1);
        location1.setLocationName("Worli");
        location1.setAddress("Dr E Moses Rd, Worli Naka, Upper Worli");
        location1.setPincode(400018);
       location1.setCity(cityDao.findById(11).get());

        Location location2=new Location();
        location2.setLocationId(2);
        location2.setLocationName("Chembur");
        location2.setAddress("Optic Complex");
       location2.setPincode(400019);
       location2.setCity(cityDao.findById(11).get());

        Location location3=new Location();
        location3.setLocationId(3);
        location3.setLocationName("Powai");
        location3.setAddress("Hiranandani Tower");
        location3.setPincode(400020);
        location3.setCity(cityDao.findById(11).get());
        locationDao.saveAll(List.of(location1, location2, location3));
}}
