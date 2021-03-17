package com.updrad.hirewheels.entities;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int vehicleId;
    @Column(name="vehicle_model", length =50,nullable = false)
    private String vehicleModel;
    @Column(name="vehicle_number", length =10, nullable = false)
    private String vehicleNumber;
    @Column(name = "color", length =50, nullable = false)
    private String color;
    @Column(nullable = false)
    private  boolean availabilityStatus;
    @Column(length = 500)
    private String vehicleImgUrl;
    @ManyToOne
    @JoinColumn(name = "vehicle_sub_category",nullable = false)
    private VehicleSubCategory vehicleSubCategory;
    @ManyToOne
    @JoinColumn(name = "fuel_type", nullable = false)
    private FuelType fuelType;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    private Set<Booking> bookings;

    public Vehicle() {
    }
    public Vehicle(int vehicleId, String vehicleModel, String vehicleNumber, String color, boolean availabilityStatus, String vehicleImgUrl,
                   VehicleSubCategory vehicleSubCategory, FuelType fuelType, Location location) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.availabilityStatus = availabilityStatus;
        this.vehicleImgUrl = vehicleImgUrl;
        this.vehicleSubCategory = vehicleSubCategory;
        this.fuelType = fuelType;
        this.location = location;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getVehicleImgUrl() {
        return vehicleImgUrl;
    }

    public void setVehicleImgUrl(String vehicleImgUrl) {
        this.vehicleImgUrl = vehicleImgUrl;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }


    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleSubCategory getVehicleSubcategory() {
        return vehicleSubCategory;
    }

    public void setVehicleSubcategory(VehicleSubCategory vehicleSubCategory) {
        this.vehicleSubCategory = vehicleSubCategory;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleNumber=" + vehicleNumber +
                ", color='" + color + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                ", vehicleImgUrl='" + vehicleImgUrl + '\'' +
                ", vehicleSubcategory=" + vehicleSubCategory +
                ", fuelType=" + fuelType +
                ", location=" + location +
                '}';
    }

}