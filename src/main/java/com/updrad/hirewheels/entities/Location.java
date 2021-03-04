package com.updrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;
    @Column(length = 50,nullable = false)
    private String locationName;
    @Column(length = 100,nullable = false)
    private String address;
    @Column(length = 10,nullable = false)
    private int pincode;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}