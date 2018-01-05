package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PermissionService {
    List<sys_permission> findAll();

    Page<sys_permission> findAll(Pageable pageable);

    void save(String name, String controller);
}
