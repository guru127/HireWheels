package com.updrad.hirewheels.entities;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column( length = 50)
    private String lastName;
    @Column(length = 50, nullable = false)
    private String password;
    @Column( length = 50, nullable = false,unique = true)
    private String email;
    @Column(length = 10,unique = true)
    private long mobileNo;
    @Column(length = 10)
    private int walletMoney;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<Booking> bookings;
    @ManyToOne
    @JoinColumn(name = "role" )
    private Role role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo=" + mobileNo +
                ", walletMoney=" + walletMoney +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && mobileNo == users.mobileNo && walletMoney == users.walletMoney && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(password, users.password) && Objects.equals(email, users.email) && Objects.equals(bookings, users.bookings) && Objects.equals(role, users.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, password, email, mobileNo, walletMoney, bookings, role);
    }
}