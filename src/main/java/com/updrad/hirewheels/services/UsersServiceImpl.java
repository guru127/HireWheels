package com.updrad.hirewheels.services;

import com.updrad.hirewheels.dao.UsersDao;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.updrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    public UsersDao usersDao;

    @Override
    public Users createUser(Users users) throws UserAlreadyExistsException {
        if (usersDao.findByEmail(users.getEmail())!=null) {
            throw new UserAlreadyExistsException("Email Already Exists");
        }
        if (usersDao.findByMobileNo(users.getMobileNo())!=null){
           throw  new UserAlreadyExistsException("Mobile Number Already Exists");
        }
        users.setWalletMoney(10000); // to set wallet money as default while adding a user
       return usersDao.save(users);
    }

    @Override
    public Users getUser(String emailId, String password) throws UserDetailsNotFoundException {
        if(usersDao.findByEmail(emailId)==null){
            throw  new UserDetailsNotFoundException("User not Registered");
        }
        Users user = usersDao.findByEmail(emailId);
        if(!user.getPassword().equals(password)){
            throw new UserDetailsNotFoundException("Invalid Credentials");
        }
        return usersDao.findByEmail(emailId);
    }

    @Override
    public Users getUserByID(int id) throws UserDetailsNotFoundException{
        Users user =usersDao.findById(id).get();
        if (user==null){
            throw  new UserDetailsNotFoundException(" user not found for given Id");
        }
        return user;
    }

    @Override
    public Users getUserByUserName(String userName) throws UserDetailsNotFoundException {
        Users user = usersDao.findByEmail(userName);
        if (user == null) {
            throw new UserDetailsNotFoundException(" user not found for given email");
        }
        return user;
    }
}
