/*
package com.nan.controller.other;

import com.nan.dao.CommentDao;
import com.nan.entity.Comment;
import com.nan.entity.CommentWithUser;
import com.nan.log.Log;
import com.nan.log.LogDao;
import com.nan.mapper.ArticleMapper;
import com.nan.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    CommentDao commentDao;
    @Autowired
    LogDao logDao;
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/")
    public String index(Model model){
        List<CommentWithUser> commentWithUsers = commentDao.queryComAllwithUser();
        List<Article> articles = articleMapper.queryArticles();
        List<Log> logs = logDao.queryAll();
        model.addAttribute("arts",articles);
        model.addAttribute("commentUser",commentWithUsers);
        model.addAttribute("logs",logs);
        System.out.println(model);
        return "main";
    }
}
*/
