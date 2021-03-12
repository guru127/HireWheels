package com.updrad.hirewheels.services;
import com.updrad.hirewheels.dao.BookingDao;
import com.updrad.hirewheels.dao.UsersDao;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.exceptions.BookingFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingSeriviceImpl implements BookingService {
    @Autowired
    public BookingDao bookingDao;
    @Autowired
    public UsersDao usersDao;
    @Override
    public Booking addBooking(Booking booking) throws BookingFailedException {
        Users users= booking.getUsers();
        System.out.println(" booking by user   "+users);
        if(users.getWalletMoney() < booking.getAmount()){
            throw  new BookingFailedException("Insufficient Balance. Please Check With Admin");
        }
        else{
            users.setWalletMoney(users.getWalletMoney()-booking.getAmount());
            usersDao.save(users);
        }
        return bookingDao.save(booking);
    }
}
