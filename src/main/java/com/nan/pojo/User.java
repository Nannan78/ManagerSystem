package com.nan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
    private int id;
    private String username;
    private String userpassword;
    private String email;
    private Date birthday;
    private String role;
}
