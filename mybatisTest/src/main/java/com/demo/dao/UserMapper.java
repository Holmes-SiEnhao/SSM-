package com.demo.dao;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: seh
 * @date: 2020/10/25 9:06
 * @version: 1.0
 */
public interface UserMapper {

//    创建一个查询方法
    @Select("select * from user where id = #{id}")
    List<User> queryUserById(@Param("id") int id);

    //创建一个插入的方法
    @Insert("insert into user(id,username,password) values(#{id},#{username},#{password})")
    int insertUser(Map map);

    @Select("select * from user")
    List<User> findAll();
}
