package com.updrad.hirewheels.dao;
import com.updrad.hirewheels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
}
