package com.nan.util;


import com.nan.dao.CommentDao;
import com.nan.mapper.ArticleMapper;
import com.nan.service.ArticleService;
import com.nan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

public class Util {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleService articleService;

    @Autowired
    CommentDao commentDao;
    @Autowired
    CommentService commentService;

    public String getCount(){

        String str="";
        return  str;
    }
}
