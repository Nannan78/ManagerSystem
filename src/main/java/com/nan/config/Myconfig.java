
package com.nan.config;
//扩展springmvc

import com.nan.controller.other.LoginHandleIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/main").setViewName("main");



    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleIntercepter()).
                addPathPatterns("/**").
                excludePathPatterns("/index.html","/","/user/login","/css/*","/js/**","/img/**","/test","book","/laydate/**",
                        "/layui/**","/loginout","/index");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

