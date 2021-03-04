package com.updrad.hirewheels.entities;
import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    @Column(nullable = false)
    private LocalDateTime bookingDate;
    @Column(nullable = false)
    private LocalDateTime dropoffDate;
    @Column(nullable = false)
    private LocalDateTime pickupDate;
    @Column(nullable = false)
    private int amount;

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

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", pickupDate='" + pickupDate + '\'' +
                ", dropoffDate='" + dropoffDate + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", amount=" + amount +
                '}';
    }
}