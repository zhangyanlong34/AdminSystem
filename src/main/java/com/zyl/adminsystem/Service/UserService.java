package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_user;

import java.util.List;

public interface UserService {
    sys_user findUserByName(String name);

    List<sys_user> findAll();
}
