package com.nan.controller.other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.nan.dao.CommentDao;
import com.nan.entity.CommentWithUser;
import com.nan.entity.LogWithUser;
import com.nan.log.Log;
import com.nan.log.LogDao;
import com.nan.mapper.ArticleMapper;
import com.nan.pojo.Article;
import com.nan.pojo.User;
import com.nan.service.LogService;
import com.nan.service.impl.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class Test {

    @Autowired
    CommentDao commentDao;
    @Autowired
    LogDao logDao;
    @Autowired
    LogServiceImpl logService;
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/")
    public String index(Model model){

        return "main";
    }
    @RequestMapping("/layui")
    public String layui(){
        return "index1";
    }

    @RequestMapping("/test3")
    public String test3(Model model, HttpServletResponse response, HttpServletRequest request)throws ServletException, IOException {


        return "test3";
    }

/*    @RequestMapping("/ajax/log")
    @ResponseBody
    public String ajax(Integer page,Integer rows )throws ServletException, IOException {

        PageInfo<Log> logPageInfo = logService.queryAllByLimit(page, rows);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("logsInfo",logPageInfo);
        System.out.println(logPageInfo);
        String str=mapper.writeValueAsString(logPageInfo);

        return str;
    }

    @RequestMapping("/ajax1/log")
    @ResponseBody
    public String ajax1(int count)throws ServletException, IOException {

        PageInfo<Log> logPageInfo = logService.queryAllByLimit(count);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("logsInfo",logPageInfo);
        System.out.println(logPageInfo);
        String str=mapper.writeValueAsString(logPageInfo);

        return str;
    }
    @RequestMapping("/getCount/log")
    @ResponseBody
    public String ajax2()throws ServletException, IOException {

        PageInfo<Log> logPageInfo = logService.queryAllByLimit(5);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("count",(int)logPageInfo.getTotal());
        String str=mapper.writeValueAsString(map);

        return str;
    }*/
}
