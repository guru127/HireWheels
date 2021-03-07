package com.updrad.hirewheels;

import com.updrad.hirewheels.dao.RoleDao;
import com.updrad.hirewheels.dao.UsersDao;
import com.updrad.hirewheels.entities.Role;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.updrad.hirewheels.services.InitService;
import com.updrad.hirewheels.services.UsersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class HireWheelsApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		InitService initService= context.getBean(InitService.class);
		initService.start();
		UsersService usersService=context.getBean(UsersService.class);
		RoleDao roleDao =context.getBean(RoleDao.class);
		UsersDao users= context.getBean(UsersDao.class);
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
	}
}
