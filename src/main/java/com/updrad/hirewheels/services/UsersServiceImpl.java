package com.updrad.hirewheels.services;

import com.updrad.hirewheels.dao.UsersDao;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    public UsersDao usersDao;

    @Override
    public Users createUser(Users users) throws UserAlreadyExistsException {
        if (usersDao.findByEmail(users.getEmail())!=null) {
            throw new UserAlreadyExistsException("this emailId already exists");
        }
        if (usersDao.findByMobileNo(users.getMobileNo())!=null){
           throw  new UserAlreadyExistsException("Mobile number already exists");
        }
       return usersDao.save(users);
    }

    @Override
    public Users getUser(String emailId, String password) throws Exception {
        if(usersDao.findByEmail(emailId)==null){
            throw  new Exception("User not Registered");
        }
        Users user = usersDao.findByEmail(emailId);
        if(!user.getPassword().equals(password)){
            throw new Exception("Unauthorized User");
        }
        return usersDao.findByEmail(emailId);
    }

}
