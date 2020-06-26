package com.yql.demo.dao;


import com.yql.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user where u_name=#{u_name}")
    public User getUser(String u_name);

    @Insert("insert into user (u_name, u_passwd, u_email, u_limit) values (#{u_name}, #{u_passwd}, #{u_email}, 'lv1')")
    public void register(User user);

    @Select("select * from `user`")
    public List<User> getAllUser();
}
