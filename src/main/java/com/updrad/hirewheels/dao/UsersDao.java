package com.updrad.hirewheels.dao;
import com.updrad.hirewheels.entities.Role;
import com.updrad.hirewheels.entities.Users;
import com.updrad.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsersDao extends JpaRepository<Users, Integer> {

    public List<Users> findByFirstName(String firstName);
    public Users findByEmail(String emailId);
    public Users findByMobileNo(long mobileNo);
    public List<Users> findByFirstNameOrLastName(String firstName, String lastName);

}
