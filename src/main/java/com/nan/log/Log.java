package com.nan.log;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Log)实体类
 *
 * @author makejava
 * @since 2020-04-13 13:18:47
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Log implements Serializable {
    private static final long serialVersionUID = 328066129101872751L;

    private Integer id;

    private Integer userId;

    private String logContent;

    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
