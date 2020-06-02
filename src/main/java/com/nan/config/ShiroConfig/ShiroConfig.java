
package com.nan.config.ShiroConfig;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.Factory;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    //shirofilterfactorybean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /*anno,无需认证
        *authc,需要认证后
        * perms,拥有对某项资源的权限才可访问
        *user,需要 remenber-me
        *role,拥有角色
        * */

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/art/*","perms[admin]");
        filterMap.put("/user/*","perms[admin]");
        filterMap.put("/comment/*","perms[admin]");
        filterMap.put("/file/*","perms[admin]");
        filterMap.put("/log/*","perms[admin]");
        bean.setFilterChainDefinitionMap(filterMap);


        //登录后设置权限不足转跳权限不足请求
        bean.setUnauthorizedUrl("/noauth");

        //未登录时设置权限不足转跳登录请求
        bean.setLoginUrl("/index");



        return bean;
    }



    //dafaultwebsecuritymanager
    @Bean(name="defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    //创建realm对象，需要自定义
    @Bean(name="myRealm")
    public MyRealm myRealm(){
        return new MyRealm();
    }


    //整合shirodialect：用来整合thyemleaf  shiro
    @Bean
    public ShiroDialect getshirodialect(){
        return  new ShiroDialect();
    }
}


