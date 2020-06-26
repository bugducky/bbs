package com.yql.demo.dao;

import com.yql.demo.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {

    /**
     * 根据a_id返回Article对象
     * @param a_id 文章的id
     * @return 返回Article对象
     */
    @Select("select * from article where a_id = #{a_id}")
    public  Article getArticleFromID(String a_id);

    /**
     * 根据分类id返回该分类的文章列表
     * @param sort_id 分类id
     * @return 文章列表
     */
    @Select("select * from article where a_sort_id= #{sort_id}")
    public List<Article> getArticlesFromSortID(int sort_id);

    /**
     * 根据分类id返回该分类下文章的属性
     * @param sort_id 分类id
     * @return 文章列表
     */
    @Select("select a_id,a_name,a_author,a_time,a_sort_id from article where a_sort_id=#{sort_id}")
    public List<Article> getArticlePropertyBySortID(int sort_id);

    /**
     * 添加一篇文章
     * @param a 文章对象
     */
    @Insert("insert into article (a_id,a_name,a_author,a_time,a_content,a_sort_id) values (#{a_id},#{a_name},#{a_author},#{a_time},#{a_content},#{a_sort_id})")
    public void postArticle(Article a);

    /**
     * 删除一篇文章
     * @param a_id 文章id
     */
    @Delete("delete article where a_id = #{a_id}")
    public void delArticle(String a_id);

    /**
     * 修改文章
     * @param a 文章对象
     */
    @Update("update article set (a_context = #{a_context}, a_name = #{a_name}, a_date = #{a_date}) where a_id = #{a_id}")
    public void updateArticle(Article a);
}
