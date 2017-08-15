package com.magicbeans.common.cache.redis;

import com.magicbeans.common.cache.MyBatisCacheClient;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis缓存操作实现
 */
public class RedisMybatisCacheClient implements MyBatisCacheClient {

    private RedisTemplate redisTemplate;


    public RedisMybatisCacheClient(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void putObject(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getObject(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Object removeObject(Object key) {
        redisTemplate.delete(key);
        return null;
    }

    public void clear() {
    }

    public int getSize() {
        return 0;
    }

}
