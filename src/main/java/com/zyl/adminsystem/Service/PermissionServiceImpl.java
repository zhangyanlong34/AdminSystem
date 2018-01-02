package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_permission;
import com.zyl.adminsystem.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<sys_permission> findAll() {
        return permissionRepository.findAll();
    }
}
