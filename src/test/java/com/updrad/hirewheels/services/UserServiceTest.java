package com.updrad.hirewheels.services;
import com.updrad.hirewheels.dao.BookingDao;
import com.updrad.hirewheels.dao.RoleDao;

import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.UserAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UsersService usersService;
    @Autowired
    public RoleDao roleDao;

    @Test
    public  void testCreateUser() throws UserAlreadyExistsException {
        Users users=new Users();
        users.setFirstName("user1");
        users.setLastName("user");
        users.setEmail("user1@gmail.com");
        users.setWalletMoney(10000);
        users.setRole(roleDao.findByRoleId(2));
        users.setPassword("123123");
        users.setMobileNo(9900887766l);

        Users savedUser = usersService.createUser(users);

        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getUserId()!=0);
        Assertions.assertEquals(users,savedUser);
    }

    @Test
     public  void testGetUser() throws Exception {
         Users users=new Users();
         users.setFirstName("user2");
         users.setLastName("user");
         users.setEmail("user2@gmail.com");
         users.setWalletMoney(10000);
         users.setRole(roleDao.findByRoleId(2));
         users.setPassword("121212");
         users.setMobileNo(9900998800l);

         usersService.createUser(users);

         Users savedUser = usersService.getUser(users.getEmail(), users.getPassword());
         Assertions.assertNotNull(savedUser);
         Assertions.assertTrue(savedUser.getUserId()==users.getUserId());
         Assertions.assertEquals(savedUser.getFirstName(),users.getFirstName());
     }
}

