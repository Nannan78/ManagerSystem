package com.nan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book  implements Serializable {
    private int id;
    private String bookName;
    private int bookCounts;
    private String detail;
}
