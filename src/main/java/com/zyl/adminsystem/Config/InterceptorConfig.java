package com.zyl.adminsystem.Config;

import com.zyl.adminsystem.Interceptor.AuthInterceptor;
import com.zyl.adminsystem.Interceptor.TokenInterceptor;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

    @Bean
    AuthInterceptor getAuthInterceptor(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getAuthInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
