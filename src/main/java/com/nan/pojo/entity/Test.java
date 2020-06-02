package com.nan.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Test)实体类
 *
 * @author makejava
 * @since 2020-04-11 11:16:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test implements Serializable {
    private static final long serialVersionUID = -69121571837049846L;

    private Integer id;

    private String string;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
