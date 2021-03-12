package com.updrad.hirewheels.validators;

import com.updrad.hirewheels.dao.LocationDao;
import com.updrad.hirewheels.dto.VehicleDTO;
import com.updrad.hirewheels.entities.Location;
import com.updrad.hirewheels.entities.VehicleSubCategory;
import com.updrad.hirewheels.exceptions.APIException;
import com.updrad.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VehicleValidatorImpl implements VehicleValidator{

    @Autowired
    public VehicleService vehicleService;
    @Autowired
    public LocationDao locationDao;

    @Override
    public void validateVehicle(VehicleDTO vehicleDTO) throws APIException {
        if (vehicleDTO.getVehicleModel() == null || vehicleDTO.getVehicleModel().length() <= 0){
              throw new APIException("vehicle model shouldn’t be null or empty’");
        }
        if (vehicleDTO.getVehicleNumber() == null || vehicleDTO.getVehicleNumber().length() <= 0){
            throw new APIException("Vehicle number shouldn’t be null or empty’");
        }
        if (vehicleDTO.getColor()== null || vehicleDTO.getColor().length() <= 0){
            throw new APIException("colour of vehicle shouldn’t be null or empty’");
        }
        if (vehicleDTO.getVehicleNumber() == null || vehicleDTO.getVehicleNumber().length() <= 0){
            throw new APIException("Vehicle number shouldn’t be null or empty’");
        }

        if (vehicleDTO.getVehicleImgUrl() == null || vehicleDTO.getVehicleImgUrl().length() <= 0){
            throw new APIException("image url shouldn’t be null or empty’");
        }
        if (vehicleDTO.getLocationId() <= 0){
            throw new APIException("LocationId shouldn’t be null or empty’");
        }
        if (vehicleDTO.getVehicleSubCategoryId()<= 0 ){
            throw new APIException("VehicleSubCategoryId shouldn’t be null or empty’");
        }
        if (vehicleDTO.getFuelTypeId()<= 0 ){
            throw new APIException("FuelTypeId shouldn’t be null or empty’");
        }


        Optional<Location> location = locationDao.findById(vehicleDTO.getLocationId());
        if(location==null){
            throw  new APIException("Invalid status value");
        }

    }
}
