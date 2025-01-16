package com.easy.hospital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 匹配需要跨域的路径
                .allowedOrigins("http://8.129.96.132", "http://220.152.163.87")  // 显式指定允许的前端 IP 地址
                .allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)  // 允许携带凭证（如 Cookie）
                .maxAge(3600);
    }
}
