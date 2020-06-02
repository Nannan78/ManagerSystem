/*

package com.nan.controller;

import com.nan.config.ShiroConfig.MyRealm;
import com.nan.log.Log;
import com.nan.log.LogDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogConfigController {
    @Autowired
    LogDao logDao;

    @Pointcut("execution(public * com.nan.mapper..*.*(..)) || execution(public * com.nan.dao..*.*(..)) ")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println( "进入doBefore切面");
        // 接收到请求，记录请求内容
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String class_name = signature.getClass().getName();
        String method = signature.getMethod().getName();
        System.out.println("类名类名类名类名类名类名类名类名类名类名类名"+class_name);
        System.out.println("类名类名类名类名类名类名类名类名类名类名类名"+method);
        String content="";
        Date date = new Date();
        switch (method){
                case "queryUsers" : content="查询所有用户"; break;
                case "queryUserById" : content="根据ID查询用户";break;
                case "addUser" : content="增加用户";break;
                case "deleteUser" : content="删除用户";break;
                case "queryUserByName" : content="根据用户名查询用户";break;
                case "queryUsersPermission" : content="查询用户权限";break;
                case "queryUsersArticles" : content="查询用户文章";break;

                case "queryComAll" : content="查询所有评论";break;
                case "queryComById" : content="根据ID查询评论";break;
                case "insertCom" : content="增加评论";break;
                case "updateCom" : content="修改评论";break;
                case "deleteComById" : content="删除评论";break;
                case "queryComAllwithUser" : content="查询所有用户评论";break;

                case "queryArticles" : content="查询所有文章";break;
                case "queryArticleById" : content="根据ID查询文章";break;
                case "addArticle" : content="增加文章";break;
                case "updateArticle" : content="修改文章";break;
                case "deleteArticle" : content="删除文章";break;
                case "queryArticleByName" : content="根据用户名查询文章";break;

        }

        if(MyRealm.theUser!=null){
            logDao.insert(new Log(0,MyRealm.theUser.getId(),content,date));
        }

        System.out.println("注解方式AOP执行的方法 :"+method+" 执行完了");

    }

}

*/
