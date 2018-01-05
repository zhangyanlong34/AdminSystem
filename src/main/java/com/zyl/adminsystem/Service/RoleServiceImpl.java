package com.zyl.adminsystem.Service;


import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<sys_role> findAll(Pageable pageable) {
        if(pageable == null){
            return new PageImpl<sys_role>(this.findAll(),pageable,0);
        }
        return roleRepository.findAll(pageable);
    }

    @Override
    public List<sys_role> findAll() {
        return roleRepository.findAll();
    }
}
