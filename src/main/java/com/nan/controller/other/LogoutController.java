package com.nan.controller.other;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LogoutController {
    @RequestMapping("/user/loginout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            request.getSession().removeAttribute("loginUser");

            request.getRequestDispatcher("/").forward(request,response);

    }

    @RequestMapping("/logout")
    public String lotout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/main";
    }
}
