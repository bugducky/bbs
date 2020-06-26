package com.yql.demo.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sort {
    private int sort_id;
    private String sort_name;
    private int article_num;
}
