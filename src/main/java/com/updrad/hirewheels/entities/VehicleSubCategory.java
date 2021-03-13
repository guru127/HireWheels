package com.updrad.hirewheels.entities;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class VehicleSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleSubCategoryId;
    @Column(length = 50, nullable = false)
    private String vehicleSubCategoryName;
    @ManyToOne
    @JoinColumn(name = "vehicle_category")
    private VehicleCategory vehicleCategory;
    @Column(nullable = false)
    private double pricePerDay;
    @OneToMany(mappedBy = "vehicleSubCategory")
    private Set<Vehicle> vehicles;

    public VehicleSubCategory() {
    }

    public VehicleSubCategory(int vehicleSubCategoryId, String vehicleSubCategoryName, VehicleCategory vehicleCategory,
                              double pricePerDay) {
        this.vehicleSubCategoryId = vehicleSubCategoryId;
        this.vehicleSubCategoryName = vehicleSubCategoryName;
        this.vehicleCategory = vehicleCategory;
        this.pricePerDay = pricePerDay;
    }

    public int getVehicleSubCategoryId() {
        return vehicleSubCategoryId;
    }

    public void setVehicleSubCategoryId(int vehicleSubCategoryId) {
        this.vehicleSubCategoryId = vehicleSubCategoryId;
    }

    public String getVehicleSubCategoryName() {
        return vehicleSubCategoryName;
    }

    public void setVehicleSubCategoryName(String vehicleSubCategoryName) {
        this.vehicleSubCategoryName = vehicleSubCategoryName;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory{" +
                "vehicleSubcategoryId=" + vehicleSubCategoryId +
                ", vehicleSubcategoryName='" + vehicleSubCategoryName + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}