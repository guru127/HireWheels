package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.VehicleDTO;
import com.updrad.hirewheels.entities.Vehicle;
import com.updrad.hirewheels.services.AdminService;
import com.updrad.hirewheels.services.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/hirewheels/v1")
public class AdminController {
    @Autowired
    public AdminService adminService;
    @Autowired
    public VehicleService vehicleService;

    @Autowired
    public ModelMapper modelMapper;


    @GetMapping(value= {"/sayHello"})
    public String sayHello(){
    //    logger.info("Hello from the MovieController");
        return "Hello";
    }

    @PostMapping(value="/Vehicles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity newVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle newVehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle savedVehicle = adminService.registerVehicle(newVehicle);
        VehicleDTO savedVehicleDTO = modelMapper.map(savedVehicle, VehicleDTO.class);
        return new ResponseEntity<>(savedVehicleDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/Vehicle/{id}")
    public ResponseEntity changeAvailability(@PathVariable(name = "id") int id) {
        Vehicle responseVehicle = vehicleService.getVehicleById(id);
        Vehicle vehicle= adminService.changeAvailability(responseVehicle);

        VehicleDTO responseVehicleDTO = modelMapper.map(vehicle,VehicleDTO.class);
        return new ResponseEntity<>(responseVehicleDTO, HttpStatus.OK);
    }
}
