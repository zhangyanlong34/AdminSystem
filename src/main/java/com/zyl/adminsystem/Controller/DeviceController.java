package com.zyl.adminsystem.Controller;

import com.zyl.adminsystem.Config.AuthType;
import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Entity.sys_user;
import com.zyl.adminsystem.Repository.UserRepository;
import com.zyl.adminsystem.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * class_name: DeviceController
 * package: com.zyl.adminsystem.Controller
 * describe: 网关的控制器
 * creat_user: zhangyanlong
 * creat_date: 2018/1/23
 * creat_time: 下午2:56
 **/
@RequestMapping("/Device")
@RestController
public class DeviceController {

    /*@Autowired
    private DeviceService deviceService;

    @RequestType(AuthType.SELECT)
    @ResponseBody
    @RequestMapping("/findAllUserDevice")
    public List<Map> findAllUserDevice() {
        return deviceService.findAllUserDevice();
    }

    @RequestType(AuthType.SELECT)
    @ResponseBody
    @RequestMapping("/findUserDeviceByDevice")
    public List<Map> findUserDeviceByDevice(@RequestParam("deviceId") String deviceId) {
        return deviceService.findUserDeviceByDevice(deviceId);
    }

    @RequestType(AuthType.SELECT)
    @ResponseBody
    @RequestMapping("/findUserDeviceByUser")
    public List<Map> findUserDeviceByUser(@RequestParam("userId") String userId) {
        return deviceService.findUserDeviceByUser(userId);
    }

    @RequestType(AuthType.INSERT)
    @ResponseBody
    @RequestMapping("/bindingDeviceUser")
    public void bindingDeviceUser(@RequestParam("userName")String userName,@RequestParam("deviceId") String deviceId) {
        deviceService.bindingDeviceUser(userName,deviceId);
    }

    @RequestType(AuthType.DELETE)
    @ResponseBody
    @RequestMapping("/unbindingDeviceUser")
    public void unbindingDeviceUser(@RequestParam("userName")String userName,@RequestParam("deviceId") String deviceId) {
        deviceService.unbindingDeviceUser(userName, deviceId);
    }*/
}
