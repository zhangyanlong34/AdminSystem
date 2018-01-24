package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_permission;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@CacheConfig(cacheNames = "permissions")
public interface PermissionRepository extends JpaRepository<sys_permission,Integer> {
    @Cacheable(key = "#p0")
    sys_permission findByController(String controller);

    @CacheEvict(key = "#p0.controller")
    sys_permission save(sys_permission permission);

    @Query(value = "select * from sys_permission t where t.id in (select st.permission_id from sys_role_permission st where st.role_id = ?1)",nativeQuery = true)
    List<sys_permission> findPermissionByRoleId(String role_id);
}
