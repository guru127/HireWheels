package com.updrad.hirewheels.validators;

import com.updrad.hirewheels.dto.UsersDTO;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationValidatorImpl implements RegistrationValidator{
    @Override
    public void ValidateNewUser(UsersDTO usersDTO) throws APIException {
        if(usersDTO.getFirstName()==null || usersDTO.getFirstName().length()<=0){
            throw new APIException("FirstName cannot be null or empty");
        }
        if(usersDTO.getEmail()==null || usersDTO.getEmail().length()<=0){
            throw new APIException("EmailId cannot be null or empty");
        }
        if(String.valueOf(usersDTO.getMobileNo()).length()!=10){
            throw new APIException("Mobile Number cannot be null or empty and must be 10 digits");
        }
    }
}
