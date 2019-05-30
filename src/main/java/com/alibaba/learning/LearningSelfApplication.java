package com.alibaba.learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.alibaba.learning.mapper")
public class LearningSelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSelfApplication.class, args);
        "chhc".contains(String.valueOf("cha".charAt(1)));
    }
}
