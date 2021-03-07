package com.updrad.hirewheels.dao;

import com.updrad.hirewheels.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository <Role, Integer>{
    public Role findByRoleId(int roleId);
}
