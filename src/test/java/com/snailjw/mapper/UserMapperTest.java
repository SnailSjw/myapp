package com.snailjw.mapper;

import com.snailjw.entity.User;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setId(10L);
        user.setAge(23);
        user.setEmail("123@163.com");
        user.setName("zhangsan");
        userMapper.insert(user);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testUpdate(){
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setId(1L);
        user.setAge(23);
        user.setEmail("123@163.com");
        user.setName("zhangsan");
        userMapper.updateById(user);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}