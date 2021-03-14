package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.updrad.hirewheels.exceptions.UserDetailsNotFoundException;

public interface UsersService {
    public Users createUser(Users users) throws UserAlreadyExistsException;
    public Users getUser(String emailId, String password) throws UserDetailsNotFoundException;
    public Users getUserByID(int id) throws  UserDetailsNotFoundException;
    public Users getUserByUserName(String userName) throws UserDetailsNotFoundException;
}
