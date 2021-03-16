package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.ResponseDTO;
import com.updrad.hirewheels.dto.VehicleDTO;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.*;
import com.updrad.hirewheels.services.AdminService;
import com.updrad.hirewheels.services.UsersService;
import com.updrad.hirewheels.services.VehicleService;
import com.updrad.hirewheels.validators.VehicleValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@RequestMapping(value = "/hirewheels/v1")
public class AdminController {
    @Autowired
    public AdminService adminService;
    @Autowired
    public VehicleService vehicleService;
    @Autowired
    public UsersService usersService;
    @Autowired
    public ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public VehicleValidator vehicleValidator;

    @PostMapping(value="/Vehicles", consumes = MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity newVehicle(@RequestBody VehicleDTO vehicleDTO, @RequestHeader (value = "ACCESS-TOKEN") String token)
            throws VehicleRegistrationFailedException, APIException, UserDetailsNotFoundException, NotAuthorisedException {
        if (token==null){
            throw new APIException("Please add proper authentication");
        }
        Users user1= usersService.getUserByUserName(token);
        if(Objects.nonNull(user1)){
            if(!usersService.getUserByUserName(token).getRole().getRoleName().equalsIgnoreCase("Admin")){
                throw new NotAuthorisedException("Unauthorized. Only 'Admin' can access this API");
            }
        }else {
            throw new UserDetailsNotFoundException("user deatails not found for the token");
        }
        vehicleValidator.validateVehicle(vehicleDTO);
        Vehicle newVehicle = modelMapper.map(vehicleDTO, Vehicle.class);;
        Vehicle savedVehicle = adminService.registerVehicle(newVehicle);
        VehicleDTO savedVehicleDTO = modelMapper.map(savedVehicle, VehicleDTO.class);
        if (Objects.nonNull(savedVehicleDTO)){
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setTimeStamp(LocalDateTime.now());
            responseDTO.setMessage("Vehicle Added Successfully");
            responseDTO.setStatusCode(200);
            logger.debug("adding new vehicle : "+ savedVehicleDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        }else {
            throw new VehicleRegistrationFailedException("vehicle registration failed ");
        }
    }


    @PutMapping(value = "/Vehicle/{id}")
    public ResponseEntity changeAvailability(@PathVariable(name = "id") int id, @RequestHeader (value = "ACCESS-TOKEN") String token)
            throws VehicleDetailsNotFoundException, VehicleSatusException, APIException, UserDetailsNotFoundException, NotAuthorisedException {
        if (token==null){
            throw new APIException("Please add proper authentication");
        }
        if(!usersService.getUserByUserName(token).getRole().getRoleName().equalsIgnoreCase("Admin")){
            throw new NotAuthorisedException(" Unauthorized. Only 'Admin' can access this API");
        }
        Vehicle responseVehicle = vehicleService.getVehicleById(id);
        Vehicle vehicle= adminService.changeAvailability(responseVehicle);
        VehicleDTO responseVehicleDTO = modelMapper.map(vehicle,VehicleDTO.class);
        if (responseVehicleDTO.isAvailabilityStatus()==false){
            logger.debug("changing availability status : "+responseVehicleDTO);
            ResponseDTO responseDTO= new ResponseDTO();
            responseDTO.setTimeStamp(LocalDateTime.now());
            responseDTO.setMessage("Activity Performed Successfully");
            responseDTO.setStatusCode(200);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }else {
            throw new VehicleSatusException("Changing Vehicle Status failed");
        }

    }
}
