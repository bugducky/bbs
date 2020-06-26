package com.yql.demo.dao;


import com.yql.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 通过用户名查找用户对象
     * @param u_name 用户名
     * @return 返回一个User对象
     */
    @Select("select * from user where u_name=#{u_name}")
    public User getUser(String u_name);

    /**
     * 添加用户
     * @param user 用户的对象
     */
    @Insert("insert into user (u_name, u_passwd, u_email, u_limit) values (#{u_name}, #{u_passwd}, #{u_email}, 'lv1')")
    public void register(User user);

    /**
     * 删除一个用户
     * @param u_name 用户名
     */
    @Delete("delete from user where u_name = #{u_name}")
    public void deleteUser(String u_name);

    /**
     * 查找所有用户
     * @return 返回所有用户的列表
     */
    @Select("select * from user")
    public List<User> getAllUser();

    /**
     * 修改用户信息
     * @param user 用户对象
     */
    @Update("update user set u_passwd = ${u_passwd}, u_email = #{u_email}, u_limit = #{u_limit} where u_name = #{u_name}")
    public void updateUser(User user);

//    /**
//     * 修改用户密码
//     * @param u_name 用户姓名
//     * @param u_passwd 用户密码
//     */
//    @Update("update user set u_passwd = #{u_passwd} where u_name = #{u_name}")
//    public void updatePasswd(String u_name,String u_passwd);
//
//    /**
//     * 修改用户权限
//     * @param u_name 用户名
//     * @param u_limit 新的权限
//     */
//    @Update("update user set u_limit = #{u_limit} where u_name = #{u_name}")
//    public void updateLimit(String u_name, String u_limit);
//
//    /**
//     * 修改用户邮箱
//     * @param u_name 用户名
//     * @param u_email 新的邮箱
//     */
//    @Update("update user set u_email = #{u_email} where u_name = #{u_name}")
//    public void updateEmail(String u_name, String u_email);
}
