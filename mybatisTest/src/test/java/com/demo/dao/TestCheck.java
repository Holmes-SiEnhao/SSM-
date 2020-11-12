package com.demo.dao;

import com.demo.pojo.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: seh
 * @date: 2020/11/11 9:15
 * @version: 1.0
 */
public class TestCheck {

    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("zs123456");
        mapper.addUser(user);
        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.removeUser(1);
        sqlSession.close();
    }

    @Test
    public void updateUserInfo(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("id",2);
        map.put("username","zhangsan");
        map.put("password","132");
        mapper.alterInfo(map);
        sqlSession.close();
    }

    @Test
    public void findAllUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.queryAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void findUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
//        map.put("id",2);
//        map.put("username","user2");
//        map.put("password","123");
        List<User> userList = mapper.queryUser(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void findUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        HashMap map = new HashMap();
        map.put("uid",arrayList);
        List<User> userList = mapper.queryForeach(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void findAllUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("username","zhangsan");
        map.put("password","456");
        List<User> userList = mapper.queryAll2(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void queryUserLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("startIndex",0);
        map.put("pageSize",3);
        List<User> userList = mapper.queryLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void fuzzyQueryUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.fuzzyQuery("user");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
