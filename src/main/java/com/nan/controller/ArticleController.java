package com.nan.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nan.mapper.ArticleMapper;
import com.nan.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/arts")
    public String list(Model model){
        List<Article> articles = articleMapper.queryArticles();
        System.out.println(articles);
        model.addAttribute("arts",articles);
        return "arts/list";
    }

    @GetMapping("/toaddart")
    public String toAddpage(){
        return "arts/add";
    }

    @GetMapping("/addart")
    public String Addpage(Article art){
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss秒");
        Date date1 =new Date();

        System.out.println(myFmt.format(date1));
        art.setDate(date1);
        System.out.println();
        articleMapper.addArticle(art);
        return "redirect:/art/arts";
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdatepage(@PathVariable("id") Integer id, Model model){
        Article art = articleMapper.queryArticleById(id);
        model.addAttribute("art",art);
        Collection<Article> arts = articleMapper.queryArticles();
        model.addAttribute("arts",arts);
        return "arts/update";
    }

    @RequestMapping("/update")
    public String Updatepage(Article art){
        articleMapper.updateArticle(art);
        return "redirect:/art/arts";
    }

    @RequestMapping("/todelete")
    public String toDeletepage(Integer id){
        System.out.println("=========================================================");
        articleMapper.deleteArticle(id);
        return "redirect:/art/arts";
    }

    @RequestMapping("/todeleteAjax")
    @ResponseBody
    public String toDeletepageAjax(String id) throws JsonProcessingException {
        System.out.println("=========================================================");
        System.out.println(id);

        List<Article> articles = articleMapper.queryArticles();
        ObjectMapper mapper = new ObjectMapper();
        String str=mapper.writeValueAsString(articles);
        return str;
    }

/*
    @RequestMapping("/update")
    public String Updatepage(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }*/

}
