package com.updrad.hirewheels.validators;

import com.updrad.hirewheels.dto.LoginDTO;
import com.updrad.hirewheels.dto.UsersDTO;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.APIException;

public interface RegistrationValidator {
    public void ValidateNewUser(UsersDTO usersDTO) throws APIException;
    public void validateUserLogin(LoginDTO user) throws APIException;
}
