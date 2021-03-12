package com.updrad.hirewheels.controllers;

import com.updrad.hirewheels.dto.VehicleDTO;
import com.updrad.hirewheels.entities.Vehicle;
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
@RequestMapping(value = "/hirewheel/v1")
public class VehicleController {

    @Autowired
    public VehicleService vehicleService;

     @Autowired
    public  ModelMapper modelMapper;

    @GetMapping(value= "/sayHelloMovie")
    public String sayHello() {
        return "Hello World To All From VehicleController";
    }

    @GetMapping(value = "/Vehicles",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getVehicles(){
        List<Vehicle> vehicleList=vehicleService.getAllVehicles();
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDTOList.add(modelMapper.map(vehicle, VehicleDTO.class));
        }
        return  new ResponseEntity<>(vehicleDTOList, HttpStatus.OK);
    }
  //  public ResponseEntity getVehicles(@RequestParam(value = "categoryName") String name)
}
