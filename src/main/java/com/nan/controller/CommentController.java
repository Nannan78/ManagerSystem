
package com.nan.controller;


import com.nan.dao.CommentDao;
import com.nan.entity.Comment;
import com.nan.entity.CommentWithUser;
import com.nan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentDao commentDao;
    @Autowired
    UserMapper userMapper;

  /*  @RequestMapping("/comments")
    public String list(Model model) {
        System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
        List<Comment> commentList = commentDao.queryAll();

        Iterator<Comment> iterator = commentList.iterator();

        List<String> userList=new ArrayList<String>();


        while(iterator.hasNext()) {
            userList.add(userMapper.queryUserById(iterator.next().getUserId()).getUsername());
        }

        Map<String,Comment> map=new HashMap<String,Comment>();

        for(Comment c:commentList){
            for(String u:userList){
                System.out.println(c);
                System.out.println(u);
                map.put(u,c);

            }
        }

        System.out.println(map);
        model.addAttribute("maps",map);
        return "comments/list";
    }*/

    @RequestMapping("/comments")
    public String list(Model model) {
        List<CommentWithUser> commentWithUsers = commentDao.queryComAllwithUser();
        System.out.println(commentWithUsers);
        model.addAttribute("commentUser",commentWithUsers);
        return "comments/list";
    }

    @GetMapping("/toaddcomment")
    public String toAddpage() {

        return "comments/add";
    }

    @GetMapping("/addcomment")
    public String Addpage(Comment comment) {
        commentDao.insertCom(comment);
        return "redirect:/comment/comments";
    }

    @RequestMapping("/toupdate/{id}")
    public String toUpdatepage(@PathVariable("id") Integer id, Model model) {
        Comment comment = commentDao.queryComById(id);
        model.addAttribute("comment", comment);
        return "comments/update";
    }

    @RequestMapping("/update")
    public String Updatepage(Comment comment) {
        commentDao.updateCom(comment);
        return "redirect:/comment/comments";
    }

    @RequestMapping("/todelete")
    public String toDeletepage(Integer id) {
        commentDao.deleteComById(id);
        return "redirect:/comment/comments";
    }

    @RequestMapping("/examine/{id}")
    public String toExamine(@PathVariable("id") Integer id) {
        System.out.println("999999999999999999999999999999999999999999999");
        Comment comment = commentDao.queryComById(id);
        System.out.println(comment);
        comment.setStatus(1);
        System.out.println(comment);
        commentDao.updateCom(comment);
        return "redirect:/comment/comments";
    }


}





