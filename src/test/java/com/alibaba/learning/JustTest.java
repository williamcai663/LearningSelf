package com.alibaba.learning;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JustTest {

    @Test
    public void IntegerEqual(){
        Assert.assertEquals(Integer.valueOf(2),Integer.valueOf(2));
    }
}
