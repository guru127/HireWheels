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
    private long vehicleNumber;
    @Column(name = "color", length =50, nullable = false)
    private String color;
    @Column(nullable = false)
    private  boolean availabilityStatus;
    @Column(length = 500)
    private String vehicleImgUrl;
    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory")
    private VehicleSubcategory vehicleSubcategory;
    @ManyToOne
    @JoinColumn(name = "fuel_type")
    private FuelType fuelType;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    private Set<Booking> bookings;

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

    public VehicleSubcategory getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
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
                ", vehicleSubcategory=" + vehicleSubcategory +
                ", fuelType=" + fuelType +
                ", location=" + location +
                '}';
    }
}