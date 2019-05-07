package com.alibaba.learning.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfiguration {

//    @Bean
//    public RedisTemplate<Object,Object> getTemplate(RedisConnectionFactory redisConnectionFactory) {
//      RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<>();
//      redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        Jackson2JsonRedisSerializer json2Redis=new Jackson2JsonRedisSerializer(Object.class);
//
//        redisTemplate.setKeySerializer(json2Redis);
//        redisTemplate.setValueSerializer(json2Redis);
//        return redisTemplate;
//
//    }
@Bean
public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
    RedisTemplate<Object, Object> template = new RedisTemplate();
    template.setConnectionFactory(redisConnectionFactory);

    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    jackson2JsonRedisSerializer.setObjectMapper(new ObjectMapper());

    template.setKeySerializer(jackson2JsonRedisSerializer);
    template.setValueSerializer(jackson2JsonRedisSerializer);

    return template;
}
}
