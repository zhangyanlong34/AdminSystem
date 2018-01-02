package com.zyl.adminsystem.Interceptor;

import com.zyl.adminsystem.Tools.JwtTools;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("校验Token");
        String token = httpServletRequest.getHeader("X-Token");
        if(StringUtils.isEmpty(token)){
            if(!httpServletRequest.getRequestURI().contains("/user/login") && !httpServletRequest.getRequestURI().contains("/user/info")) {
                return false;
            }else{
                return true;
            }
        }
        Map map = JwtTools.parserJavaWebToken(token);
        httpServletRequest.setAttribute("role_id", map.get("role_id").toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
