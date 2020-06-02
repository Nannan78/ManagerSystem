package com.nan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Files)实体类
 *
 * @author makejava
 * @since 2020-04-13 22:11:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Files implements Serializable {
    private static final long serialVersionUID = -11363824535555343L;

    private Integer id;

    private String oldname;

    private String newname;

    private String ext;

    private String path;

    private double size;

    private String type;

    private String isstring;

    private Integer count;

    private Date date;

}
