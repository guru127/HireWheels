package com.updrad.hirewheels.dao;

import com.updrad.hirewheels.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location, Integer> {
}
