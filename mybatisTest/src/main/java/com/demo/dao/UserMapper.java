package com.demo.dao;
import com.demo.pojo.User;
import org.apache.ibatis.annotations.*;

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

//    这是一个删除的方法
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);

//    这是一个修改方法
    @Update("update user set password = #{password} where id = #{id}")
    int updateUser(Map map);
}
