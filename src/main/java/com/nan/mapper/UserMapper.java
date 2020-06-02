package com.nan.mapper;


import com.nan.pojo.Article;
import com.nan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUsers();

    User queryUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

    User queryUserByName(String userName);

    List<String> queryUsersPermission(int id);

    List<Article> queryUsersArticles(int id);
}
