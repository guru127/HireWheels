package com.updrad.hirewheels.entities;
import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    @Column(nullable = false)
    private LocalDate bookingDate;
    @Column(nullable = false)
    private LocalDateTime dropoffDate;
    @Column(nullable = false)
    private LocalDateTime pickupDate;
    @Column(nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name="Location_id",nullable = false)
    private Location location;
    @ManyToOne
    @JoinColumn(name = "vehicle_id",nullable = false)
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    public Booking() {
    }

    public Booking(int bookingId, LocalDate bookingDate,  LocalDateTime pickupDate,LocalDateTime dropoffDate, int amount,
                   Location location, Vehicle vehicle, Users users) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.amount = amount;
        this.location = location;
        this.vehicle = vehicle;
        this.users = users;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDateTime getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDateTime dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", dropoffDate=" + dropoffDate +
                ", pickupDate=" + pickupDate +
                ", amount=" + amount +
                ", location=" + location +
                ", vehicle=" + vehicle +
                ", users=" + users +
                '}';
    }
}