package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<sys_user,Integer> {

    sys_user findAllByName(String name);
}
