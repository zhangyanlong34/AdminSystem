package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_permission;

import java.util.List;


public interface PermissionService {
    List<sys_permission> findAll();
}
