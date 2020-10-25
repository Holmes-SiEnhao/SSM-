package com.demo.dao;

import com.demo.pojo.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author: seh
 * @date: 2020/10/25 9:13
 * @version: 1.0
 */
public class TestCode {

    @Test
    public void TestQuery(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.queryUserById(1);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("id",2);
        map.put("username","user1");
        map.put("password","1234");
        mapper.insertUser(map);
        sqlSession.close();
    }
    @Test
    public void findAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
