package com.yql.demo.dao;

import com.yql.demo.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {
    @Insert("insert into comment values (#{comment_id},#{comment_a_id},#{comment_text},#{comment_date},#{comment_user})")
    boolean subComment(Comment c);

    @Select("select * from comment where comment_a_id = #{comment_a_id}")
    public List<Comment> getComments(String comment_a_id);
}
