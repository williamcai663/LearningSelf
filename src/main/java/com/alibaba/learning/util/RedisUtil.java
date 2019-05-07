package com.alibaba.learning.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;


public class RedisUtil{

//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Autowired(required = false)
//    public void
//    setRedisTemplate(RedisTemplate redisTemplate) {
//
//
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        this.redisTemplate=redisTemplate;
//
//    }
//    public void set(String key, String value) {
//        ValueOperations<String, String> valueops = redisTemplate
//                .opsForValue();
//        valueops.set(key,value);
//    }

}
