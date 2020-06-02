package com.nan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogWithUser implements Serializable {
    private Integer id;

    private Integer user_id;

    private String log_content;

    private Date date;

    private String userName;
}
