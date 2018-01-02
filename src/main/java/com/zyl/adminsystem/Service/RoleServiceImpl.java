package com.zyl.adminsystem.Service;


import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<sys_role> findAll() {
        return roleRepository.findAll();
    }
}
