package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_permission;
import com.zyl.adminsystem.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Page<sys_permission> findAll(Pageable pageable) {
        if(pageable == null){
            return new PageImpl<sys_permission>(this.findAll(),pageable,0);
        }
        return permissionRepository.findAll(pageable);
    }

    @Override
    public void save(String name, String controller) {
        sys_permission permission = new sys_permission();
        permission.setName(name);
        permission.setController(controller);
        permissionRepository.save(permission);
    }

    @Override
    public List<sys_permission> findAll() {
        return permissionRepository.findAll();
    }
}
