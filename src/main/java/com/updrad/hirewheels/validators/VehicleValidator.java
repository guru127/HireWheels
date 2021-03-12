package com.updrad.hirewheels.validators;

import com.updrad.hirewheels.dto.VehicleDTO;
import com.updrad.hirewheels.exceptions.APIException;

public interface VehicleValidator {
    public void validateVehicle(VehicleDTO vehicleDTO) throws APIException;
}
