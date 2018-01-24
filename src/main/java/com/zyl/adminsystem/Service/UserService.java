package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_permission;
import com.zyl.adminsystem.Entity.sys_user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {
    sys_user findUserByName(String name);

    Page<sys_user> findAll(Pageable pageable);

    void save(String username,String password,String roles);

    void delete(int id);

    sys_user update(sys_user user);

    List<sys_permission> findMenu(String role_id);
}
