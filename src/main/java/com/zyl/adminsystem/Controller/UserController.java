package com.zyl.adminsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyl.adminsystem.Common.ResponseMessage;
import com.zyl.adminsystem.Config.AuthType;
import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Entity.sys_user;
import com.zyl.adminsystem.Service.UserService;
import com.zyl.adminsystem.Tools.JwtTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username,@RequestParam("password") String password){
        if(username.equals("admin")&&password.equals("123456")){
            sys_user user = userService.findUserByName(username);
            List<sys_role> roleList = user.getRoles();
            StringBuffer stringBuffer = new StringBuffer();
            roleList.forEach(sys_role -> {
                stringBuffer.append(stringBuffer.length()==0?sys_role.getId():","+sys_role.getId());
            });
            JSONObject json = new JSONObject();
            json.put("username",username);
            json.put("password",password);
            json.put("user_id",user.getId());
            json.put("role_id", stringBuffer.toString());
            String token = JwtTools.createJavaWebToken(json);
            json.put("token",token);
            return ResponseMessage.buildSuccessMessage(json);
        }else{
            return false;
        }
    }

    @RequestType(AuthType.SELECT)
    @ResponseBody
    @RequestMapping("/info")
    public Object info(@RequestParam("token") String token){
        Map map = JwtTools.parserJavaWebToken(token);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",map.get("username").toString());
        jsonObject.put("role","admin");
        return ResponseMessage.buildSuccessMessage(jsonObject);
    }

    @RequestType(AuthType.SELECT)
    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAllPermission(){
        List<sys_user> list = userService.findAll();
        List<Map> mapList = new ArrayList<Map>();
        for(sys_user sys_user : list){
            Map<String,String> map = new HashMap<>();
            map.put("id",sys_user.getId().toString());
            map.put("name",sys_user.getName());
            map.put("password",sys_user.getPassword());
            mapList.add(map);
        }
        return mapList;
    }
}
