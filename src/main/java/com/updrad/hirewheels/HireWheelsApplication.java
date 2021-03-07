package com.updrad.hirewheels;

import com.updrad.hirewheels.dao.RoleDao;
import com.updrad.hirewheels.dao.UsersDao;
import com.updrad.hirewheels.entities.Role;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.services.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class HireWheelsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		InitService initService= context.getBean(InitService.class);
		initService.start();

		/*UsersDao usersDao = context.getBean(UsersDao.class);
		RoleDao roleDao = context.getBean(RoleDao.class);

		Role admin=new Role();
		admin.setRoleName("Admin");
		admin = roleDao.save(admin);

		Role user=new Role();
		user.setRoleName("User");
		user = roleDao.save(user);

		Users users1 = new Users();
		users1.setFirstName("guru");
		users1.setLastName("n");
		users1.setPassword("123456");
		users1.setWalletMoney(500);
		users1.setEmail("guru.com");
		users1.setMobileNo(9988774455l);
		users1.setRole(admin);

		Users users2 = new Users();
		users2.setFirstName("charan");
		users2.setLastName("G");
		users2.setPassword("123456");
		users2.setWalletMoney(550);
		users2.setEmail("charan.com");
		users2.setMobileNo(9966332211l);
		users2.setRole(user);

		Users users3 = new Users();
		users3.setFirstName("guru");
		users3.setLastName("charan");
		users3.setPassword("123456");
		users3.setWalletMoney(600);
		users3.setEmail("gcn.com");
		users3.setMobileNo(889977665);
		users3.setRole(user);

		Users users4 = new Users();
		users4.setFirstName("abhi");
		users4.setLastName("mishra");
		users4.setPassword("123456");
		users4.setWalletMoney(800);
		users4.setEmail("abm.com");
		users4.setMobileNo(889988998);
		users4.setRole(user);

		Users users5 = new Users();
		users5.setFirstName("raj");
		users5.setLastName("dr");
		users5.setPassword("123456");
		users5.setWalletMoney(700);
		users5.setEmail("dr.raj.com");
		users5.setMobileNo(998497363);
		users5.setRole(user);
		usersDao.saveAll(List.of(users1, users2, users3, users4, users5));

		System.out.println("find by first name : ");
		usersDao.findByFirstName("guru")
				.forEach(users -> System.out.println(users.getFirstName()));

		System.out.println("find by first name and last name : ");
		usersDao.findByFirstNameOrLastName(" ","G")
				.forEach(users -> System.out.println(users.getFirstName()));

		System.out.println("find by email : ");
		usersDao.findByEmail(
				"gcn.com")
				.forEach(users -> System.out.println(users.getFirstName()));

		System.out.println("find by mobile no : ");
		usersDao.findByMobileNo(889977665)
				.forEach(users -> System.out.println(users.getFirstName()));
*/	}

}
