package com.nan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nan.dao.CommentDao;
import com.nan.entity.Comment;
import com.nan.mapper.ArticleMapper;
import com.nan.pojo.Article;
import com.nan.service.ArticleService;
import com.nan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2020-04-15 13:50:13
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

   /* *//**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     *//*
    @Override
    public Comment queryById(Integer id) {
        return this.commentDao.queryById(id);
    }

    *//**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageInfo<Article> queryAllByLimit(int offset, int limit) {

        PageHelper.startPage(offset, limit);
        List<Article> articles = articleMapper.queryArticles();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        PageInfo pageInfo = new PageInfo(articles);

        return pageInfo;
    }

    @Override
    public PageInfo<Article> queryAllByLimit(int count) {

        PageHelper.startPage(1, count);
        List<Article> articles = articleMapper.queryArticles();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        PageInfo pageInfo = new PageInfo(articles);

        return pageInfo;
    }


    @Override
    public PageInfo<Article> queryAllByLimitDesc(int offset, int limit) {

        PageHelper.startPage(offset, limit);
        List<Article> articles = articleMapper.queryArticlesDesc();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        PageInfo pageInfo = new PageInfo(articles);

        return pageInfo;
    }

    @Override
    public PageInfo<Article> queryAllByLimitDesc(int count) {

        PageHelper.startPage(1, count);
        List<Article> articles = articleMapper.queryArticlesDesc();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        PageInfo pageInfo = new PageInfo(articles);

        return pageInfo;
    }


  /*  *//**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     *//*
    @Override
    public Comment insert(Comment comment) {
        this.commentDao.insert(comment);
        return comment;
    }

    *//**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     *//*
    @Override
    public Comment update(Comment comment) {
        this.commentDao.update(comment);
        return this.queryById(comment.getId());
    }

    *//**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     *//*
    @Override
    public boolean deleteById(Integer id) {
        return this.commentDao.deleteById(id) > 0;
    }*/
}
