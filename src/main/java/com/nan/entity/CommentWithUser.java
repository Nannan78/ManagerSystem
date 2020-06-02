package com.nan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentWithUser implements Serializable {

    private Integer id;

    private Integer artId;

    private Integer userId;

    private String content;

    private Date date;

    private Integer status;

    private String username;
}
