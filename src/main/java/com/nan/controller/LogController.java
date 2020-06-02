package com.nan.controller;

import com.nan.entity.LogWithUser;
import com.nan.log.Log;
import com.nan.log.LogDao;
import com.nan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    LogDao logDao;

/*    @RequestMapping("/logs")
    public String showLogs(Model model){
        List<LogWithUser> logWithUsers = logDao.queryAllWithUser();
        model.addAttribute("logs",logWithUsers);
        return "log/list";
    }*/
    @RequestMapping("/logs")
    public String showLogs(Model model){
        List<Log> logs = logDao.queryAll();
        model.addAttribute("logs",logs);
        return "log/list";
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdatepage(@PathVariable("id") Integer id, Model model){
        System.out.println("=========================================================");
        Log log = logDao.queryById(id);
        model.addAttribute("log",log);
        return "log/update";
    }

    @RequestMapping("/update")
    public String Updatepage(Log log){
        logDao.update(log);
        return "redirect:/log/logs";
    }

    @RequestMapping("/todelete")
    public String toDeletepage(Integer id){
        logDao.deleteById(id);
        return "redirect:/log/logs";
    }
}
