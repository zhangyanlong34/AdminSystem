package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface RoleService {
    Page<sys_role> findAll(Pageable pageable);
    List<sys_role> findAll();

    void save(String name, String permission);
}
