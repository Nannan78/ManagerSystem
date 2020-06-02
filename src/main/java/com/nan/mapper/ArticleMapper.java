package com.nan.mapper;

import com.nan.log.Log;
import com.nan.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {
    List<Article> queryArticles();
    List<Article> queryArticlesDesc();



    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Article queryArticleById(int id);

    int addArticle(Article article);

    int deleteArticle(int id);

    int updateArticle(Article article);

    Article queryArticleByName(String articleName);
}
