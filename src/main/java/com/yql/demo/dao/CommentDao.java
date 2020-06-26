package com.yql.demo.dao;

import com.yql.demo.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {
    /**
     * 添加评论
     * @param c 评论对象
     */
    @Insert("insert into comment values (#{comment_id},#{comment_a_id},#{comment_text},#{comment_date},#{comment_user})")
    public void subComment(Comment c);

    /**
     * 根据文章id查找该文章下的评论
     * @param comment_a_id 文章id
     * @return 评论列表
     */
    @Select("select * from comment where comment_a_id = #{comment_a_id}")
    public List<Comment> getComments(String comment_a_id);

    /**
     * 删除一条评论
     * @param comment_id 评论id
     */
    @Delete("delete comment where comment_id = #{comment_id")
    public void delComment(String comment_id);

    /**
     * 修改评论
     * @param c 评论对象
     */
    @Update("update comment set (comment_text = #{comment_text}, comment_date = #{comment_date) where comment_id = #{comment_id}")
    public void updateComment(Comment c);

}
