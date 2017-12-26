package com.zyl.adminsystem.Config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestTypeConfig {

    @Before("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(requestType)")
    public void requestType(final JoinPoint joinPoint,RequestType requestType){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        for(Object obj : args){
            if(obj instanceof HttpServletRequest){
                request = (HttpServletRequest) obj;
                break;
            }
        }
        String pemission = "";
        int requestTypeName = requestType.value();
        System.out.println("请求类型="+requestTypeName);

    }
}
