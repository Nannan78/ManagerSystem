package com.nan.config;


import com.nan.mapper.UserMapper;
import com.nan.pojo.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AuthenticationSuccessHandler successHandler;
    @Autowired
    AuthenticationFailureHandler failureHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
     /*   http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/dep/deps").hasRole("Dep")
                .antMatchers("/emp/emps").hasRole("Emp");

        //没有权限默认跳转到内置登录页面
        http.formLogin().loginPage("/index").loginProcessingUrl("/login")
        .failureHandler(failureHandler).successHandler(successHandler);


        //去除跨站網站攻擊
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/main");
        http.rememberMe().rememberMeParameter("remember");*/


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      /*  List<User> userList = userMapper.queryUsers();
        Map<String,String> map=new HashMap<>();
        for(User user:userList){
            map.put(user.getUsername(),user.getUserpassword());
        }
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode(map.get("admin"))).roles("Dep","Emp")
                .and()
                .withUser("zhang").password(new BCryptPasswordEncoder().encode(map.get("zhang"))).roles("Emp")
                .and()
                .withUser("li").password(new BCryptPasswordEncoder().encode(map.get("li"))).roles("Dep");


*/
    }
}
