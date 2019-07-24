package com.example.springbootmybatisdemo.util;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.exceptions.JedisException;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @auther lhj
 * @desc 分布式锁
 * @Company
 * @create 2019/7/10 17:48
 */
@Component
public class DistributedLock {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistributedLock.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     *
     * @param lockName 锁名
     * @param timeout 超时时间
     * @return 值
     */
    public String lockWithTimeout(String lockName, long timeout) {
        String retIdentifier = null;
        try {
            // 随机生成一个value
            String identifier = UUID.randomUUID().toString();
            // 锁名，即key值
            String lockKey = "lock:" + lockName;
            // 超时时间，上锁后超过此时间则自动释放锁
            int lockExpire = (int)(timeout / 1000);
            while (true) {
                if (stringRedisTemplate.opsForValue().setIfAbsent(lockKey, identifier)) {
                    LOGGER.info("{}:获取到锁lockKey：{}", Thread.currentThread().getName(), lockKey);
                    stringRedisTemplate.expire(lockKey, lockExpire, TimeUnit.SECONDS);
                    // 返回value值，用于释放锁时间确认
                    retIdentifier = identifier;
                    break;
                }
                // 返回-1代表key没有设置超时时间，为key设置一个超时时间
                if (stringRedisTemplate.getExpire(lockKey) == -1L) {
                    stringRedisTemplate.expire(lockKey, lockExpire, TimeUnit.SECONDS);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (JedisException e) {
            e.printStackTrace();
        }
        return retIdentifier;
    }

    /**
     *
     * @param lockName   锁名
     * @param identifier 值
     * @return
     */
    public boolean releaseLock(String lockName, String identifier) {
        String lockKey = "lock:" + lockName;
        boolean retFlag = false;
        try {
            while (true) {
                // 监视lock，准备开始事务
                stringRedisTemplate.watch(lockKey);
                // 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
                if (identifier.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                    LOGGER.info("{}:删除锁lockKey：{}", Thread.currentThread().getName(), lockKey);
                    stringRedisTemplate.delete(lockKey);
                    retFlag = true;
                }
                stringRedisTemplate.unwatch();
                break;
            }
        } catch (JedisException e) {
            e.printStackTrace();
        }
        return retFlag;
    }
}
