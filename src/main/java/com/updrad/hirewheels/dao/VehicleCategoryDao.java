package com.updrad.hirewheels.dao;

import com.updrad.hirewheels.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryDao extends JpaRepository <VehicleCategory, Integer>{
   public VehicleCategory findByVehicleCategoryId(int vehicleCategoryId);
}
