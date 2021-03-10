package com.updrad.hirewheels.dto;

import com.updrad.hirewheels.entities.FuelType;
import com.updrad.hirewheels.entities.Location;

public class VehicleDTO {
    private  int vehicleId;
    private String vehicleModel;
    private String vehicleNumber;
    private String color;
    private  boolean availabilityStatus;
    private String vehicleImgUrl;
    private int vehicleSubCategoryId;
    private int fuelTypeId;
    private int LocationId;

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

    public int getVehicleSubCategoryId() {
        return vehicleSubCategoryId;
    }

    public void setVehicleSubCategoryId(int vehicleSubCategoryId) {
        this.vehicleSubCategoryId = vehicleSubCategoryId;
    }

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int locationId) {
        LocationId = locationId;
    }
}
