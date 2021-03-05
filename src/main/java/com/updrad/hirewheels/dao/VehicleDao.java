package com.updrad.hirewheels.dao;

import com.updrad.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {
}
