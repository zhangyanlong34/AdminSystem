package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<sys_role,Integer> {
}
