package com.hthyaq.learnadmin.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class PageResourceCorsConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //前端页面相关的js、css、img等资源无法访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("*.jpg").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("*.js").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("*.css").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("*.ico").addResourceLocations("classpath:/static/");
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        //跨域、cookie问题
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true);
    }
}
