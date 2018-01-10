package com.zyl.adminsystem.Interceptor;

import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Entity.sys_permission;
import com.zyl.adminsystem.Entity.sys_role_permission;
import com.zyl.adminsystem.Repository.PermissionRepository;
import com.zyl.adminsystem.Repository.RolePermissionRepository;
import com.zyl.adminsystem.Tools.AuthTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!request.getRequestURI().contains("/user/login") && !request.getRequestURI().contains("/user/info")) {
            System.out.println("校验Auth");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String controllerName = handlerMethod.getMethod().getDeclaringClass().getName();
            controllerName = controllerName.substring(controllerName.lastIndexOf('.') + 1);
            sys_permission sys_permission = permissionRepository.findByController(controllerName);
            RequestType requestType = handlerMethod.getMethodAnnotation(RequestType.class);
            System.out.println("requestType" + requestType.value());
            String role = request.getAttribute("role_id").toString();
            if("1".equals(role)){
                return true;
            }
            sys_role_permission role_permission = rolePermissionRepository.findByRoleIdAndPermissionId(Integer.parseInt(role),sys_permission.getId());
            int permission = role_permission.getValue();
            boolean result = AuthTools.getAuth(permission, requestType.value());
            if (!result) {
                response.setStatus(401);
            }
            return result;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
