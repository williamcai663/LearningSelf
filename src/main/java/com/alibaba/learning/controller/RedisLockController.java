package com.alibaba.learning.controller;

import com.alibaba.learning.handler.DistributeLockHandler;
import com.alibaba.learning.util.Lock;
import com.alibaba.learning.util.RedisUtil;
import com.alibaba.learning.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Api(value = "redis的controller")
@RestController
@RequestMapping("/api")
public class RedisLockController {

    @Autowired
    private DistributeLockHandler distributeLockHandler;

    @Autowired
    private RedisUtils redisUtil;

    @ApiOperation(value = "获取学生列表")
    @GetMapping("/redis-lock/test")
    public void doSomething() throws Exception {
        Lock lock = new Lock("lock", "fuck123");
        if (distributeLockHandler.getLock(lock)) {
            int i = 0;
            do {
                System.out.println(i++);
            } while (i < 20);
            TimeUnit.SECONDS.sleep(22);
            distributeLockHandler.releaseLock(lock);
        }
    }
    @GetMapping("/redis")
    public  void setRedis(){
        redisUtil.set("xiaoyu","fuck");
    }

    @GetMapping("/getObject")
    public Object testRestTemplate(){
        HashMap<String,Object> result=new HashMap<>();
        result.put("id","123");
        result.put("name","caicai");
        result.put("address","hubei");
        return result;
    }

    @GetMapping(value = "/{name}/home")
    public String  toHome(@PathVariable  String name ){
        System.out.println(
                name

        );
        return "index";
    }

}
