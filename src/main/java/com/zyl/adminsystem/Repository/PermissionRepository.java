package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<sys_permission,Integer> {
}
