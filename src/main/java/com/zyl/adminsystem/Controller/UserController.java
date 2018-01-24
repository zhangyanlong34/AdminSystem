package com.zyl.adminsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyl.adminsystem.Common.ResponseMessage;
import com.zyl.adminsystem.Config.AuthType;
import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Entity.sys_permission;
import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Entity.sys_user;
import com.zyl.adminsystem.Service.UserService;
import com.zyl.adminsystem.Tools.JwtTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username,@RequestParam("password") String password){
        sys_user user = userService.findUserByName(username);
        if(null!=user && password.equals(user.getPassword())){
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
    public Object findAllUser(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize){
        Pageable pageable = new PageRequest(page,pageSize);
        Page<sys_user> results = userService.findAll(pageable);
        int count = results.getTotalPages();
        List<sys_user> list = results.getContent();
        list.forEach(sys_user -> sys_user.setRoles(null));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",count);
        jsonObject.put("data",JSONObject.toJSONString(list));
        return jsonObject;
    }

    @RequestType(AuthType.SELECT)
    @RequestMapping("/validatorUsername")
    @ResponseBody
    public Object validatorUsername(@RequestParam("name") String username){
        sys_user sys_user = userService.findUserByName(username);
        return null==sys_user?"1":"0";
    }

    @RequestType(AuthType.INSERT)
    @RequestMapping("/save")
    @ResponseBody
    public Object save(@RequestParam("name") String username,@RequestParam("password")String password,@RequestParam("roles")String roles){
        userService.save(username,password,roles);
        return null;
    }

    @RequestType(AuthType.DELETE)
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestParam("id") String id){
        int user_id = Integer.parseInt(id);
        userService.delete(user_id);
        return null;
    }

    @RequestType(AuthType.UPDATE)
    @RequestMapping("/update")
    @ResponseBody
    public Object update(@RequestBody sys_user sys_user){
        userService.update(sys_user);
        return null;
    }

    @RequestType(AuthType.SELECT)
    @RequestMapping("/findMenu")
    @ResponseBody
    public Object findMenu(HttpServletRequest request){
        String role_id = request.getAttribute("role_id").toString();
        System.out.println("role_id="+role_id);
        List<sys_permission> list = userService.findMenu(role_id);
        list.forEach( sys_permission -> sys_permission.setRoles(null));
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }


}
