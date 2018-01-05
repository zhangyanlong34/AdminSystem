package com.zyl.adminsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyl.adminsystem.Config.AuthType;
import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestType(AuthType.SELECT)
    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAllUser(@RequestParam(value="page",required = false) Integer page, @RequestParam(value="pageSize",required = false) Integer pageSize){
        Page<sys_role> results = null;
        if(null==page){
            results = roleService.findAll(null);
        }else{
            Pageable pageable = new PageRequest(page,pageSize);
            results = roleService.findAll(pageable);
        }
        int count = results.getTotalPages();
        List<sys_role> list = results.getContent();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",count);
        jsonObject.put("data", JSON.toJSONString(list));
        return jsonObject;
    }
}
