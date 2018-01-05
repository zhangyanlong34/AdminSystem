package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_user_role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<sys_user_role,Integer> {
}
