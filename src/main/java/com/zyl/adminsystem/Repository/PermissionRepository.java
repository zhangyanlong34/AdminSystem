package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_permission;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "permissions")
public interface PermissionRepository extends JpaRepository<sys_permission,Integer> {
    @Cacheable(key = "#p0")
    sys_permission findByController(String controller);

    @CacheEvict(key = "#p0.controller")
    sys_permission save(sys_permission permission);

}
