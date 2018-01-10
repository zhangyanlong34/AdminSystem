package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_user;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<sys_user,Integer> {

    @Cacheable(key = "#p0")
    sys_user findAllByName(String name);

    @CacheEvict(key = "#p0.name")
    sys_user save(sys_user user);
}
