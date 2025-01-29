package com.easy.hospital.config;

import com.easy.hospital.interceptors.JWTInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptors())
                .addPathPatterns("/api/easy-online-hospital/**") // 需要拦截的路径
                .excludePathPatterns("/api/easy-online-hospital/sysUser/login")
                .excludePathPatterns("/api/easy-online-hospital/sysUser/register");
    }
}
