
package com.nan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.nan.dao.CommentDao;
import com.nan.entity.Comment;
import com.nan.log.Log;
import com.nan.log.LogDao;
import com.nan.mapper.ArticleMapper;
import com.nan.pojo.Article;
import com.nan.service.ArticleService;
import com.nan.service.CommentService;
import com.nan.service.impl.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;


@Controller
public class AjaxController {

    @Autowired
    CommentDao commentDao;
    @Autowired
    CommentService commentService;

    @Autowired
    LogDao logDao;
    @Autowired
    LogServiceImpl logService;

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/getCount/log")
    @ResponseBody
    public String ajax2()throws ServletException, IOException {

        PageInfo<Log> logPageInfo = logService.queryAllByLimit(5);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("count",(int)logPageInfo.getTotal());
        String str=mapper.writeValueAsString(map);

        return str;
    }

    @RequestMapping("/ajax/log")
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













    @RequestMapping("/getCount/comm")
    @ResponseBody
    public String ajax2comm()throws ServletException, IOException {

        PageInfo<Comment> commentPageInfo = commentService.queryAllByLimit(5);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("count",(int)commentPageInfo.getTotal());
        String str=mapper.writeValueAsString(map);

        return str;
    }

    @RequestMapping("/ajax/comm")
    @ResponseBody
    public String ajaxcomm(Integer page,Integer rows )throws ServletException, IOException {

        PageInfo<Comment> commentPageInfo = commentService.queryAllByLimitDesc(page, rows);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("commsInfo",commentPageInfo);
        System.out.println(commentPageInfo);
        String str=mapper.writeValueAsString(commentPageInfo);

        return str;
    }

    @RequestMapping("/ajax1/comm")
    @ResponseBody
    public String ajax1comm(int count)throws ServletException, IOException {

        PageInfo<Comment> commentPageInfo = commentService.queryAllByLimitDesc(count);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("commsInfo",commentPageInfo);
        System.out.println(commentPageInfo);
        String str=mapper.writeValueAsString(commentPageInfo);

        return str;
    }

    @RequestMapping("/getCount/art")
    @ResponseBody
    public String ajax2art()throws ServletException, IOException {

        PageInfo<Article> artPageInfo = articleService.queryAllByLimit(5);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("count",(int)artPageInfo.getTotal());
        String str=mapper.writeValueAsString(map);

        return str;
    }

    @RequestMapping("/ajax/art")
    @ResponseBody
    public String ajaxart(Integer page,Integer rows )throws ServletException, IOException {

        PageInfo<Article> artPageInfo = articleService.queryAllByLimitDesc(page, rows);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("artsInfo",artPageInfo);
        System.out.println(artPageInfo);
        String str=mapper.writeValueAsString(artPageInfo);

        return str;
    }

    @RequestMapping("/ajax1/art")
    @ResponseBody
    public String ajax1art(int count)throws ServletException, IOException {

        PageInfo<Article> artPageInfo = articleService.queryAllByLimitDesc(count);

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();

        map.put("artsInfo",artPageInfo);
        System.out.println(artPageInfo);
        String str=mapper.writeValueAsString(artPageInfo);

        return str;
    }

}

