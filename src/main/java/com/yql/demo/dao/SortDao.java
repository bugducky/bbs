package com.yql.demo.dao;


import com.yql.demo.entity.Sort;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SortDao {
    /**
     * 查找所有分类
     * @return 返回所有分类的列表
     */
    @Select("select * from sort")
    public List<Sort> getAllSort();

    /**
     * 更新某个分类下的文章数量
     * @param a_sort_id 分类的id
     */
    @Update("update sort set article_num = article_num + 1 where sort_id = #{a_sort_id}")
    public void addArticleNum(long a_sort_id);

    /**
     * 添加一个分类
     * @param sort_name 分类名称
     */
    @Insert("insert into sort (sort_name, article_num) values (#{sort_name}, 0)")
    public void addSort(String sort_name);

    /**
     * 删除一个分类
     * @param sort_id 分类id
     */
    @Delete("delete sort where sort_id = #{sort_id}")
    public void delSort(int sort_id);

    /**
     * 修改分类的名称
     * @param sort_id 分类id
     * @param sort_name 新的分类名称
     */
    @Update("update sort set sort_name = #{sort_name} where sort_id = #{sort_id}")
    public void updateSortName(int sort_id, String sort_name);

    /**
     * 根据sort_id返回分类对象
     * @param sort_id sort_id
     * @return Sort对象
     */
    @Select("select * from sort where sort_id = #{sort_id}")
    public Sort getSortByID(int sort_id);
}
