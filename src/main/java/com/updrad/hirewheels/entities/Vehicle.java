package com.updrad.hirewheels.entities;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int vehicleId;
    @Column(name="vehicle_model", length =50,nullable = false)
    private String vehicleModel;
    @Column(name="vehicle_number", length =10, nullable = false)
    private long vehicleNumber;
    @Column(name = "color", length =50, nullable = false)
    private String color;
    @Column(name = "location_id", length = 10,nullable = false)
    private int locationId;
    @Column(name = "fuel_type_id", length = 10,nullable = false)
    private int fuelTypeId;
    @Column(nullable = false)
    private  boolean availabilityStatus;
    @Column(length = 500)
    private String vehicleImgUrl;

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

    public long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleNumber=" + vehicleNumber +
                ", color='" + color + '\'' +
                ", locationId=" + locationId +
                ", fuelTypeId=" + fuelTypeId +
                ", availabilityStatus=" + availabilityStatus +
                ", vehicleImgUrl='" + vehicleImgUrl + '\'' +
                '}';
    }
}