package com.nan.cache;

import com.nan.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;


public class RedisCache implements Cache {

    private String id;

/*
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate;
*/


    public RedisCache(String id){
        System.out.println("id:"+id);
        this.id=id;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());


        redisTemplate.opsForHash().put(id.toString(),key.toString(),value);
    }

    @Override
    public  Object getObject(Object o) {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        Object o1 =  redisTemplate.opsForHash().get(id.toString(),o.toString());
        return o1;
    }

    @Override
    public Object removeObject(Object o) {
        System.out.println("remove");
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.delete(id.toString());
    }

    @Override
    public int getSize() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }
}
