package com.yql.demo.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Comment {

  private String comment_id;
  private String comment_a_id;
  private String comment_text;
  private String comment_date;
  private String comment_user;


}
