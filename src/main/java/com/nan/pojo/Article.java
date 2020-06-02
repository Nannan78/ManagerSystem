package com.nan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private Integer id;
    private String article_name;
    private String article_style;
    private String article_content;
    private Date date;
    private Integer user_id;


}
