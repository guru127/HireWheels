package com.updrad.hirewheels.services;
import com.updrad.hirewheels.dao.BookingDao;
import com.updrad.hirewheels.dao.UsersDao;
import com.updrad.hirewheels.entities.Booking;
import com.updrad.hirewheels.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingSeriviceImpl implements BookingService {
    @Autowired
    public BookingDao bookingDao;
    @Autowired
    public UsersDao usersDao;
    @Override
    public Booking addBooking(Booking booking, Users users) throws Exception {
        if(users.getWalletMoney()<booking.getAmount()){
            throw  new Exception("Insufficient Balance. Please Check With Admin");
        }
        else{
            users.setWalletMoney(users.getWalletMoney()-booking.getAmount());
            usersDao.save(users);
        }
        return bookingDao.save(booking);
    }
}
