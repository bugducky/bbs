package com.yql.demo.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Article {

  private String a_id;
  private String a_name;
  private String a_author;
  private String a_time;
  private String a_content;
  private long a_sort_id;
  private long a_comment_num;
  private long a_like_num;
  private long a_is_hot;

}
