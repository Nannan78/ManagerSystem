package com.nan.config.ShiroConfig;

import com.nan.mapper.UserMapper;
import com.nan.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //拿到user对象
        User currentUser = (User) subject.getPrincipal();
        List<String> list = userMapper.queryUsersPermission(currentUser.getId());
        //可以对当前对象授予数据库中的权限
        for(String per:list){
            System.out.println(per);
            info.addStringPermission(per);
        }
        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //用户名密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.queryUserByName(token.getUsername());
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("login",user);
        System.out.println(user);


        if(user==null){
            return null;
        }

        //密码认证
        return new SimpleAuthenticationInfo(user,user.getUserpassword(),"");


    }
}
