package com.zyl.adminsystem.Service;


import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Entity.sys_role_permission;
import com.zyl.adminsystem.Repository.RolePermissionRepository;
import com.zyl.adminsystem.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

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

    @Override
    public void save(String name, String permission) {
        sys_role role = new sys_role();
        role.setName(name);
        role = roleRepository.save(role);
        List<sys_role_permission> role_permissions = new ArrayList<>();
        if(!StringUtils.isEmpty(permission)){
            String[] permissions = permission.split(";");
            for(String t : permissions){
                String[] p = t.split(":");
                sys_role_permission role_permission = new sys_role_permission();
                role_permission.setRoleId(role.getId());
                role_permission.setPermissionId(Integer.parseInt(p[0]));
                role_permission.setValue(Integer.parseInt(p[1]));
                role_permissions.add(role_permission);
            }
            rolePermissionRepository.save(role_permissions);
        }
    }
}
