package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.VehicleDTO;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.exceptions.APIException;
import com.updrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.updrad.hirewheels.exceptions.VehicleRegistrationFailedException;
import com.updrad.hirewheels.exceptions.VehicleSatusException;
import com.updrad.hirewheels.services.AdminService;
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

@RestController
@RequestMapping(value = "/hirewheels/v1")
public class AdminController {
    @Autowired
    public AdminService adminService;
    @Autowired
    public VehicleService vehicleService;

    @Autowired
    public ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public VehicleValidator vehicleValidator;

    @PostMapping(value="/Vehicles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newVehicle(@RequestBody VehicleDTO vehicleDTO) throws VehicleRegistrationFailedException, APIException {
        vehicleValidator.validateVehicle(vehicleDTO);
        Vehicle newVehicle = modelMapper.map(vehicleDTO, Vehicle.class);;
        Vehicle savedVehicle = adminService.registerVehicle(newVehicle);

        VehicleDTO savedVehicleDTO = modelMapper.map(savedVehicle, VehicleDTO.class);
        logger.debug("adding new vehicle : "+ savedVehicleDTO);
        return new ResponseEntity<>(savedVehicleDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/Vehicle/{id}")
    public ResponseEntity changeAvailability(@PathVariable(name = "id") int id) throws VehicleDetailsNotFoundException , VehicleSatusException {
        Vehicle responseVehicle = vehicleService.getVehicleById(id);
        Vehicle vehicle= adminService.changeAvailability(responseVehicle);
        VehicleDTO responseVehicleDTO = modelMapper.map(vehicle,VehicleDTO.class);
        logger.debug("changing availability status : "+responseVehicleDTO);
        return new ResponseEntity<>(responseVehicleDTO, HttpStatus.OK);
    }
}
