package com.yql.demo.dao;


import com.yql.demo.entity.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface SortDao {
    @Select("select * from sort")
    public ArrayList<Sort> getAllSort();

    @Update("update sort set article_num = article_num + 1 where sort_id = #{a_sort_id}")
    public void addArticleNum(long a_sort_id);
}
