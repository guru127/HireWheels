package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.BookingDTO;
import com.updrad.hirewheels.dto.UsersDTO;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.UserDetailsNotFoundException;
import com.updrad.hirewheels.services.UsersService;
import com.updrad.hirewheels.validators.RegistrationValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity newUser(@RequestBody UsersDTO usersDTO) throws Exception {
        registrationValidator.ValidateNewUser(usersDTO);
        Users user = modelMapper.map(usersDTO, Users.class);
        Users savedUser = usersService.createUser(user);
        return new ResponseEntity<>("User Successfully Signed Up", HttpStatus.CREATED);
    }

    @GetMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity getUser(@RequestParam(value = "emailId") String emailId, @RequestParam(value = "password") String password) throws UserDetailsNotFoundException {
        Users users = usersService.getUser(emailId, password);
        UsersDTO responseUser= modelMapper.map(users, UsersDTO.class);
        return new ResponseEntity<>(responseUser,  HttpStatus.FOUND);
    }
}
