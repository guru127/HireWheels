package com.updrad.hirewheels.entities;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleCategoryId;
    @Column(length = 50,nullable = false,unique = true)
    private  String VehicleCategoryName;
    @OneToMany(mappedBy = "vehicleCategory")
    private Set<VehicleSubCategory> vehicleSubCategory;

    public VehicleCategory() {
    }

    public VehicleCategory(int vehicleCategoryId, String vehicleCategoryName){
        this.vehicleCategoryId = vehicleCategoryId;
        this.VehicleCategoryName = vehicleCategoryName;

    }

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return VehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        VehicleCategoryName = vehicleCategoryName;
    }

    public Set<VehicleSubCategory> getVehicleSubCategory() {
        return vehicleSubCategory;
    }

    public void setVehicleSubCategory(Set<VehicleSubCategory> vehicleSubCategory) {
        this.vehicleSubCategory = vehicleSubCategory;
    }

    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleCategoryId=" + vehicleCategoryId +
                ", VehicleCategoryName='" + VehicleCategoryName + '\'' +
                '}';
    }
}