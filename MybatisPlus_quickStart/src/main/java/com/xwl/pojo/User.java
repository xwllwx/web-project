package com.xwl.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Short password;
    private Short age;
    private String tel;
}