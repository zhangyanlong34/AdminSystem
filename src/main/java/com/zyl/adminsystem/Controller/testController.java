package com.zyl.adminsystem.Controller;

import com.zyl.adminsystem.Config.AuthType;
import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Entity.sys_user;
import com.zyl.adminsystem.Repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class testController {

    @Resource
    private UserRepository userRepository;

    @RequestType(AuthType.UPDATE)
    @RequestMapping("/test")
    @ResponseBody
    public Object testController(){
        System.out.println("进入Controller");
        List<sys_user> userList = userRepository.findAll();
        return "test";
    }
}
