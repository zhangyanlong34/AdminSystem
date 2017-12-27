package com.zyl.adminsystem.Interceptor;

import com.zyl.adminsystem.Config.RequestType;
import com.zyl.adminsystem.Tools.AuthTools;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!request.getRequestURI().contains("/user/login") && !request.getRequestURI().contains("/user/info")) {
            System.out.println("校验Auth");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String controllerName = handlerMethod.getMethod().getDeclaringClass().getName();
            System.out.println("处理类" + controllerName.substring(controllerName.lastIndexOf('.') + 1));
            RequestType requestType = handlerMethod.getMethodAnnotation(RequestType.class);
            System.out.println("requestType" + requestType.value());
            String role = request.getParameter("role");
            int permission = 11;
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
