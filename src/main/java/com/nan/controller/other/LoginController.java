package com.nan.controller.other;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController{
    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpServletRequest request){
        if(!StringUtils.isEmpty(username)){
            request.getSession().setAttribute("loginUser",username);
            System.out.println("888888888888888888888888888888888888888888888888888888888888888888");
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }

    }

    //shiro
    @RequestMapping("/login")
    public String login(String username,String password,Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //将信息封装成令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录
        try {
            subject.login(token);
            return "redirect:/main";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            return "index";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "index";
        }
    }
    @RequestMapping("/tologin")
    public String tologin() {
        return "index";
    }
    @RequestMapping("/noauth")
    @ResponseBody
    public String noauth() {
        return "未经授权无法访问";
    }
}
