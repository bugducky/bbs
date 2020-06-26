package com.yql.demo.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private String u_name;
    private String u_passwd;
    private String u_email;
    private String u_limit;

}
