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
    private Set<VehicleSubcategory> vehicleSubcategory;

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

    public Set<VehicleSubcategory> getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(Set<VehicleSubcategory> vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleCategoryId=" + vehicleCategoryId +
                ", VehicleCategoryName='" + VehicleCategoryName + '\'' +
                '}';
    }
}