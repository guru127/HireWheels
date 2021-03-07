package com.updrad.hirewheels;

import com.updrad.hirewheels.dao.*;
import com.updrad.hirewheels.entities.*;
import com.updrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.updrad.hirewheels.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories
public class HireWheelsApplication {

	public static void main(String[] args){
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		InitService initService= context.getBean(InitService.class);
		initService.start();
		UsersService usersService=context.getBean(UsersService.class);
		RoleDao roleDao =context.getBean(RoleDao.class);
		UsersDao usersDao= context.getBean(UsersDao.class);
		AdminService adminService=context.getBean(AdminService.class);
		VehicleSubCategoryDao vehicleSubCategoryDao= context.getBean(VehicleSubCategoryDao.class);
		FuelTypeDao fuelTypeDao= context.getBean(FuelTypeDao.class);
		LocationDao locationDao= context.getBean(LocationDao.class);
		VehicleDao vehicleDao =context.getBean(VehicleDao.class);
		BookingService bookingService =context.getBean(BookingService.class);
		VehicleService vehicleService = context.getBean(VehicleService.class);

// adding users to check userServices
		Users users1 = new Users();
		users1.setFirstName("guru");
		users1.setLastName("n");
		users1.setPassword("123456");
		users1.setWalletMoney(500);
		users1.setEmail("guru.com");
		users1.setMobileNo(9988774455l);
		users1.setRole(roleDao.findByRoleId(2));
		try {
			usersService.createUser(users1);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}

		Users users2 = new Users();
		users2.setFirstName("charan");
		users2.setLastName("N");
		users2.setPassword("123456");
		users2.setWalletMoney(550);
		users2.setEmail("charan.com");
		users2.setMobileNo(9966332211l);
		users2.setRole(roleDao.findByRoleId(2));
		try {
			usersService.createUser(users2);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		// to check for unique emailId
		Users users4 = new Users();
		users4.setFirstName("abhi");
		users4.setLastName("mishra");
		users4.setPassword("123456");
		users4.setWalletMoney(800);
		users4.setEmail("charan.com");// repeated emailId
		users4.setMobileNo(889988998);
		users4.setRole(roleDao.findByRoleId(2));
		try {
			usersService.createUser(users4);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
         // to check unique Phone number
		Users users5 = new Users();
		users5.setFirstName("raj");
		users5.setLastName("dr");
		users5.setPassword("123456");
		users5.setWalletMoney(700);
		users5.setEmail("dr.raj.com");
		users5.setMobileNo(9988774455l);//repeated Phone number
		users5.setRole(roleDao.findByRoleId(2));
		try {
			usersService.createUser(users5);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
       try {
		    System.out.println( usersService.getUser("guru.com", "123456"));
	   }catch (Exception e){
	  	    System.out.println(e.getMessage());
	    }
		try {
			System.out.println(usersService.getUser("guru","123456"));

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

		try {
			System.out.println(usersService.getUser("guru.com","123455"));

		}catch (Exception e){
			System.out.println(e.getMessage());
		}
// to check adminService
		Vehicle vehicle= new Vehicle();
		vehicle.setVehicleModel("new");
		vehicle.setVehicleNumber(007);
		vehicle.setColor("red");
		vehicle.setAvailabilityStatus(true);
		vehicle.setVehicleImgUrl("image.url");
		vehicle.setVehicleSubcategory(vehicleSubCategoryDao.findById(8).get());
		vehicle.setFuelType(fuelTypeDao.findById(12).get());
		vehicle.setLocation(locationDao.findById(14).get());

		adminService.registerVehicle(vehicle);

		adminService.changeAvailability(vehicle);

// to check bookingService
		Booking booking= new Booking();
		booking.setBookingDate(LocalDateTime.now());
		booking.setPickupDate(LocalDateTime.now());
		booking.setDropoffDate(LocalDateTime.now());
		booking.setAmount(150);
		booking.setLocation(locationDao.findById(14).get());
		booking.setUsers(usersDao.findById(17).get());
		booking.setVehicle(vehicleDao.findById(19).get());
		try{
             bookingService.addBooking(booking, users1);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}

// to test vehicleService
      List<Vehicle> vehicleList	= vehicleService.getAllVehicles();
		vehicleList.forEach(System.out::println);

	}
}
