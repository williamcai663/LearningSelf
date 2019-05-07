package com.alibaba.learning;

import com.alibaba.learning.entity.User;
import com.alibaba.learning.mapper.UserMapper;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningSelfApplicationTests {


    @Autowired
    private UserMapper userMapper;



    @Test
    public void testSelect() {
        System.out.println("-----print all users");
		List<User> users=userMapper.selectList(null);
        Assert.assertEquals(1, users.size());
        users.forEach(System.out::println);

    }

}
