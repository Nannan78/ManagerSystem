
package com.nan.controller.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/test0")

    public String test(){
       String sql="select * from ssmbuild.books";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return "test0";
    }

    @RequestMapping("/1111")

    public String test11111(){
        String sql="select * from ssmbuild.books";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return "1111";
    }

    @RequestMapping("/test2")
    public String test2(){
        return "test2";
    }
    @RequestMapping("/test1")
    public String test1(){
        return "test1";
    }

    @RequestMapping("/testt")
    public String testt(String s,Model model){
        System.out.println(s);
        model.addAttribute("msg",s);
        return "test2";
    }




}

