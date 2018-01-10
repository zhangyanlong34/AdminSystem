package com.zyl.adminsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyl.adminsystem.Config.AuthType;
import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Entity.sys_permission;
import com.zyl.adminsystem.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestType(AuthType.SELECT)
    @ResponseBody
    @RequestMapping("findAll")
    public Object findAllPermission(@RequestParam(value="page",required = false) Integer page, @RequestParam(value="pageSize",required = false) Integer pageSize){
        Page<sys_permission> results = null;
        if(null==page){
            results = permissionService.findAll(null);
        }else{
            Pageable pageable = new PageRequest(page,pageSize);
            results = permissionService.findAll(pageable);
        }
        int count = results.getTotalPages();
        List<sys_permission> list = results.getContent();
        list.forEach(sys_permission -> sys_permission.setRoles(null));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",count);
        jsonObject.put("data", JSON.toJSONString(list));
        return jsonObject;
    }

    @RequestType(AuthType.INSERT)
    @RequestMapping("/save")
    @ResponseBody
    public Object save(@RequestParam("name") String name,@RequestParam("controller")String controller){
        permissionService.save(name,controller);
        return null;
    }
}
