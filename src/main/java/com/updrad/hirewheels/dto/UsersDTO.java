package com.updrad.hirewheels.dto;
import java.util.Set;

public class UsersDTO {
    private int usersId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private long mobileNo;
    private int walletMoney;
    private Set<Integer> bookingId;
    private int roleId;

    public int getUserId() {
        return usersId;
    }

    public void setUserId(int userId) {
        this.usersId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(int walletMoney) {
        this.walletMoney = walletMoney;
    }

    public Set<Integer> getBookingId() {
        return bookingId;
    }

    public void setBookingId(Set<Integer> bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
