package com.nan.controller;





import com.nan.mapper.UserMapper;


import com.nan.pojo.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
@Log4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/users")
    public String list(Model model){
        List<User> userList = userMapper.queryUsers();
        model.addAttribute("users",userList);
        log.info("输出日志吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱吱在在在在在在");
        return "users/list";
    }

    @GetMapping("/toadduser")
    public String toAddpage(){

        return "users/add";
    }

    @GetMapping("/adduser")
    public String Addpage(User user){
        userMapper.addUser(user);
        return "redirect:/user/users";
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdatepage(@PathVariable("id") Integer id, Model model){
        User user = userMapper.queryUserById(id);
        model.addAttribute("user",user);
        Collection<User> users = userMapper.queryUsers();
        model.addAttribute("users",users);
        return "users/update";
    }

    @RequestMapping("/update")
    public String Updatepage(User user){
        userMapper.updateUser(user);
        return "redirect:/user/users";
    }

    @RequestMapping("/todelete")
    public String toDeletepage(Integer id){
        userMapper.deleteUser(id);
        return "redirect:/user/users";
    }
/*
    @RequestMapping("/update")
    public String Updatepage(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }*/

}
