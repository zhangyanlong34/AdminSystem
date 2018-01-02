package com.zyl.adminsystem.Controller;

import com.zyl.adminsystem.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ResponseBody
    @RequestMapping("findAll")
    public Object findAllPermission(){
       return permissionService.findAll();
    }
}
