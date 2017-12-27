package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_user;

public interface UserService {
    sys_user findUserByName(String name);
}
