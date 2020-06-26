package com.yql.demo.dao;

import com.yql.demo.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleDao {

    @Select("select * from article where a_id = #{a_id}")
    public  Article getArticleFromID(String a_id);

    @Select("select * from article where a_sort_id= #{sort_id}")
    public List<Article> getArticlesFromSortID(int sort_id);

    @Select("select a_id,a_name,a_author,a_time,a_sort_id from article where a_sort_id=#{sort_id}")
    public List<Article> getArticlePropertyBySortID(int sort_id);

    @Insert("insert into article (a_id,a_name,a_author,a_time,a_content,a_sort_id) values (#{a_id},#{a_name},#{a_author},#{a_time},#{a_content},#{a_sort_id})")
    public void postArticle(Article a);
}
