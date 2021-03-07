package com.updrad.hirewheels.services;

import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.UserAlreadyExistsException;

public interface UsersService {
    public Users createUser(Users users) throws UserAlreadyExistsException;
    public Users getUser(String emailId, String password) throws Exception;
}
