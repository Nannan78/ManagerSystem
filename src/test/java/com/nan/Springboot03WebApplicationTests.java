package com.nan;

import com.github.pagehelper.PageInfo;
import com.nan.dao.CommentDao;
import com.nan.dao.FilesDao;
import com.nan.entity.CommentWithUser;
import com.nan.entity.Files;
import com.nan.entity.LogWithUser;
import com.nan.log.LogDao;
import com.nan.entity.Comment;
import com.nan.log.Log;
import com.nan.mapper.*;
import com.nan.pojo.*;


import com.nan.pojo.dao.TestDao;
import com.nan.service.ArticleService;
import com.nan.service.CommentService;
import com.nan.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@ComponentScan(basePackages = "com.nan.mapper")
@SpringBootTest
@RunWith(SpringRunner.class)
public class Springboot03WebApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    BookMapper bookMapper;


    @Autowired
    UserMapper userMapper;



    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleService articleService;


    @Autowired
    TestDao testDao;

    @Autowired
    CommentDao commentDao;
    @Autowired
    CommentService commentService;

    @Autowired
    LogDao logDao;
    @Autowired
    LogService logService;

    @Autowired
    FilesDao filesDao;

    @Test
    void clearCache(){

    }

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();

    }

    @Test
    public void testdatasource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }



    @Test
    public void testUser(){

        System.out.println(userMapper.queryUsers());
        int i = userMapper.deleteUser(2);

     /*   System.out.println(userMapper.queryUsersArticles(3));
        System.out.println(userMapper.queryUsersPermission(3));*/
    }

    @Test
    public void testArticle(){
    articleMapper.addArticle(new Article(1,"123","321","12312313",new Date(),2));
/*        System.out.println(articleMapper.queryArticleByName("11"));
        System.out.println(articleMapper.queryArticleById(1));
        System.out.println(articleMapper.queryArticles());
        System.out.println("!============================================!");
        System.out.println(articleService.queryAllByLimit(1,1));*/


    }

    @Test
    public void testtest(){
        System.out.println("==========================================================");
        System.out.println(testDao.queryById(1));

    }


    @Test
    public void testcomment(){
  /*      System.out.println("==========================================================");
        System.out.println(commentDao.queryComById(1));
        System.out.println(commentDao.queryComAll());
*/
        List<CommentWithUser> commentWithUsers = commentDao.queryComAllwithUser();
        for (CommentWithUser commentWithUser : commentWithUsers) {
            System.out.println(commentWithUser.toString());
        }
        /*System.out.println(commentDao.queryComAllwithUser());*/
       /* System.out.println("==========================================================");
        System.out.println(commentService.queryAllByLimitDesc(1,1));
*/
    }


    @Test
    public void testt(){
        System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
        List<Comment> commentList = commentDao.queryComAll();

        Iterator<Comment> iterator = commentList.iterator();

        List<String> userList=new ArrayList<String>();


        while(iterator.hasNext()) {
            userList.add(userMapper.queryUserById(iterator.next().getUserId()).getUsername());
        }

        Map<Comment,String> map=new HashMap<Comment,String>();


        Iterator<String> iterator1 = userList.iterator();
        Iterator<Comment> iterator2 = commentList.iterator();
        for(int num=0;num<commentList.size();num++){
            String name=iterator1.next();
            Comment comment=iterator2.next();
            System.out.println(name);
            System.out.println(comment);
            map.put(comment,name);
        }
        System.out.println(map);
    }

    @Test
    public void testtt(){
        System.out.println("999999999999999999999999999999999999999999999");
        Comment comment = commentDao.queryComById(2);
        System.out.println(comment);
        comment.setStatus(1);
        System.out.println(comment);
        commentDao.updateCom(comment);

    }

    @Test
    public void log(){
        logDao.deleteById(194);
/*        Log log = logDao.queryById(1);
        System.out.println(log);
        List<LogWithUser> logWithUsers = logDao.queryAllWithUser();
        for(LogWithUser l:logWithUsers){
            System.out.println(l.getUserName());
            System.out.println(l.getLog_content());
        }
        System.out.println(logWithUsers);*/
      /*  List<Log> logs = logDao.queryAllByLimit(1, 5);
        System.out.println(logs);*/

        PageInfo<Log> logPageInfo = logService.queryAllByLimit(2, 5);
        System.out.println("=====================================================");
        System.out.println(logPageInfo);
        System.out.println(logPageInfo.getList());
        System.out.println(logPageInfo.getPageNum());
        System.out.println(logPageInfo.getPages());
        System.out.println(logPageInfo.getSize());
        System.out.println("+++++++++++++++++====================");
        PageInfo<Log> logPageInfo1 = logService.queryAllByLimit((int) logPageInfo.getTotal());
        System.out.println(logPageInfo1);
    }

    @Test
    public void testfile(){
        List<Files> files = filesDao.queryAll();
        System.out.println(files);
    }


}
