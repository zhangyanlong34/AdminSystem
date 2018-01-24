package com.zyl.adminsystem.Repository;

import com.zyl.adminsystem.Entity.sys_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface DeviceRepository extends JpaRepository{
    @Query(value = "select d.id,t.username,s.device_id from users t,(select t.user_id,t.device_id,t.id from sys_users_devices t ) d" +
                    ",sys_devices s where s.id = d.device_id and d.user_id = t.id",nativeQuery = true)
    List<Map> findAllUserDevice();

    @Query(value = "select d.id,t.username,s.device_id from users t,(select t.user_id,t.device_id,t.id from sys_users_devices t) d" +
            ",sys_devices s where s.id = d.device_id and d.user_id = t.id and s.device_id = ?1",nativeQuery = true)
    List<Map> findUserDeviceByDevice(String deviceId);

    @Query(value = "select d.id,t.username,s.device_id from users t,(select t.user_id,t.device_id,t.id from sys_users_devices t ) d" +
            ",sys_devices s where s.id = d.device_id and d.user_id = t.id and t.username = ?1",nativeQuery = true)
    List<Map> findUserDeviceByUser(String userId);

    void bindingDeviceUser(String userName,String deviceId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from sys_users_devices where device_id = ?2 and user_id = ?1",nativeQuery = true)
    void unbindingDeviceUser(String userName,String deviceId);
}
