package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_role_permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<sys_role_permission,Integer> {

    sys_role_permission findByRoleIdAndPermissionId(Integer roleId,Integer permissionId);

    sys_role_permission save(sys_role_permission role_permission);
}
