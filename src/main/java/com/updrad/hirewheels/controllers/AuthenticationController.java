package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.BookingDTO;
import com.updrad.hirewheels.dto.LoginDTO;
import com.updrad.hirewheels.dto.ResponseDTO;
import com.updrad.hirewheels.dto.UsersDTO;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.APIException;
import com.updrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.updrad.hirewheels.exceptions.UserRegistrationFailedException;
import com.updrad.hirewheels.services.UsersService;
import com.updrad.hirewheels.validators.RegistrationValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/hirewheels/v1")
public class AuthenticationController {
    @Autowired
    public UsersService usersService;
    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public RegistrationValidator registrationValidator;

    @GetMapping(value = "hello")
    public String sayHello() {
        return "Hello World To All From AuthenticationController";
    }

    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@RequestBody UsersDTO usersDTO) throws Exception {
        registrationValidator.ValidateNewUser(usersDTO);
        Users user = modelMapper.map(usersDTO, Users.class);
        Users savedUser = usersService.createUser(user);
        if (Objects.nonNull(savedUser)){
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setTimeStamp(LocalDateTime.now());
            responseDTO.setMessage("User Successfully Signed Up");
            responseDTO.setStatusCode(HttpStatus.CREATED.value());

            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }else {
            throw new UserRegistrationFailedException("User  registration failed");
        }

    }

    @GetMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity Login(@RequestBody LoginDTO loginDTO) throws UserDetailsNotFoundException, APIException {
        registrationValidator.validateUserLogin(loginDTO);
        Users users = usersService.getUser(loginDTO.getUsername(), loginDTO.getPassword());
        UsersDTO responseUser= modelMapper.map(users, UsersDTO.class);
        Map<String, String> model= new HashMap<>();
        model.put("message :", "login successfully");
        model.put("token",users.getEmail());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
