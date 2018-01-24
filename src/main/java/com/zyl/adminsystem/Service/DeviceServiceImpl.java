package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService {

   /* @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Map> findAllUserDevice() {
        return deviceRepository.findAllUserDevice();
    }

    @Override
    public List<Map> findUserDeviceByDevice(String deviceId) {
        return deviceRepository.findUserDeviceByDevice(deviceId);
    }

    @Override
    public List<Map> findUserDeviceByUser(String userId) {
        return deviceRepository.findUserDeviceByUser(userId);
    }

    @Override
    public void bindingDeviceUser(String userName, String deviceId) {
        deviceRepository.bindingDeviceUser(userName,deviceId);
    }

    @Override
    public void unbindingDeviceUser(String userName, String deviceId) {
        deviceRepository.unbindingDeviceUser(userName, deviceId);
    }*/
}
