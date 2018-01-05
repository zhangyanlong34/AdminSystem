package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    sys_user findUserByName(String name);

    Page<sys_user> findAll(Pageable pageable);

    void save(String username,String password,String roles);
}
