package com.nan.service;

import com.github.pagehelper.PageInfo;
import com.nan.entity.Comment;
import com.nan.pojo.Article;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2020-04-15 13:50:13
 */
public interface ArticleService {

/*
    */
/**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     *//*

    Comment queryById(Integer id);
*/

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageInfo<Article> queryAllByLimit(int offset, int limit);


    PageInfo<Article> queryAllByLimit(int count);


    PageInfo<Article> queryAllByLimitDesc(int offset, int limit);

    PageInfo<Article> queryAllByLimitDesc(int count);
  /*  *//**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     *//*
    Comment insert(Comment comment);

    *//**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     *//*
    Comment update(Comment comment);

    *//**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     *//*
    boolean deleteById(Integer id);*/

}
