package com.updrad.hirewheels.services;

import com.updrad.hirewheels.dao.*;
import com.updrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        VehicleCategory vehicleCategory1= new VehicleCategory(10, "CAR");
        VehicleCategory vehicleCategory2 = new VehicleCategory(11, "BIKE");

        vehicleCategoryDao.saveAll(List.of(vehicleCategory1,vehicleCategory2));
    }

    private void addUser() {
        Users user = new Users(1,"Upgrad",  "Admin", "admin@123","upgrad@gmail.com",
                9999999999l,10000, userRoleDao.findByRoleId(1));
        usersDao.save(user);
    }

    private void addUserRole() {
        Role admin = new Role(1, "Admin");
         userRoleDao.save(admin);
        Role user = new Role(2, "User");
         userRoleDao.save(user);
    }

    private void addVehicleSubCategory() {
       VehicleSubCategory vehicleSubCategory = new VehicleSubCategory(1, "SUV", vehicleCategoryDao.findByVehicleCategoryId(11), 300);
       VehicleSubCategory vehicleSubCategory1= new VehicleSubCategory(2, "SEDAN", vehicleCategoryDao.findByVehicleCategoryId(11),350);
       VehicleSubCategory  vehicleSubCategory2=new VehicleSubCategory(3, "HATCHBACK", vehicleCategoryDao.findByVehicleCategoryId(10),250);
       VehicleSubCategory vehicleSubCategory3= new VehicleSubCategory(4, "CRUISER", vehicleCategoryDao.findByVehicleCategoryId(12),200);
       VehicleSubCategory vehicleSubCategory4= new VehicleSubCategory(5, "DIRT bIKE",vehicleCategoryDao.findByVehicleCategoryId(12),200);
       VehicleSubCategory vehicleSubCategory5= new VehicleSubCategory(6, "SPORTS BIKE", vehicleCategoryDao.findByVehicleCategoryId(12),150);

       vehicleSubCategoryDao.saveAll(List.of(vehicleSubCategory, vehicleSubCategory1, vehicleSubCategory2, vehicleSubCategory3,vehicleSubCategory4, vehicleSubCategory5,vehicleSubCategory5));
    }

    private void addCity() {
        City city = new City(1,"Mumbai");
        cityDao.save(city);
    }

    private void addFuelType() {
        FuelType fuelType1= new FuelType(1,"Petrol");
        FuelType fuelType2 =new FuelType(2,"Diesel");

        fuelTypeDao.saveAll(List.of(fuelType1,fuelType2));;
    }

    private void addLocation() {

        Location location1=new Location(1,"Worli", "Dr E Moses Rd, Worli Naka, Upper Worli",400018, cityDao.findById(11).get());
        Location location2=new Location(2,"Chembur","Optic Complex", 400019, cityDao.findById(11).get());
        Location location3=new Location(3,"Powai","Hiranandani Tower",400020, cityDao.findById(11).get());
        locationDao.saveAll(List.of(location1, location2, location3));
    }
}
