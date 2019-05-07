package com.alibaba.learning.handler;

import com.alibaba.learning.util.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Component
public class DistributeLockHandler {

    Logger logger = LoggerFactory.getLogger(DistributeLockHandler.class);
    public final static long LOCK_TRY_INTERVAL = 20L;
    public final static long LOCK_TIMEOUT = 20 * 1000L;
    public final static long LOCK_EXPIRE_TIME = 30 * 1000L;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean getLock(Lock lock) {
        return getLock(lock, LOCK_TIMEOUT, LOCK_TRY_INTERVAL, LOCK_EXPIRE_TIME);
    }

    public boolean getLock(Lock lock, long timeOut) {
        return getLock(lock, timeOut, LOCK_TRY_INTERVAL, LOCK_EXPIRE_TIME);
    }

    public boolean getLock(Lock lock, long timeOut, long tryInterval) {
        return getLock(lock, timeOut, tryInterval, LOCK_EXPIRE_TIME);
    }

    public boolean getLock(Lock lock, long timeOut, long tryInterval, long expireTime) {
        try {
            if (StringUtils.isEmpty(lock.getName()) || StringUtils.isEmpty(lock.getValue())) {
                return false;
            }
            long startTime = System.currentTimeMillis();
            do {
                if (!stringRedisTemplate.hasKey(lock.getName())) {
                    // 设置获取锁
                    ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
                    ops.set(lock.getName(), lock.getValue(), expireTime);
                    return true;
                } else {
                    logger.debug("the lock is existing");
                }
                TimeUnit.MILLISECONDS.sleep(tryInterval);
                if (System.currentTimeMillis() - startTime > timeOut) {
                    logger.debug("timeout");
                    return false;
                }
            } while (stringRedisTemplate.hasKey(lock.getName()));
        } catch (Exception e) {
            logger.error("exception:" + e.getMessage());
            return false;
        }
        return false;
    }

    public void releaseLock(Lock lock) {
        if (!StringUtils.isEmpty(lock.getName())) {
            stringRedisTemplate.delete(lock.getName());
        }
    }
}
