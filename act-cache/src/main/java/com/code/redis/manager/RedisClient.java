package com.code.redis.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

/**
 * redis客户端
 * Created by 刘长申
 * on time 2017/5/18
 */
@Service
public class RedisClient {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //普通K-V操作
    private ValueOperations valueOperations;

    //set类型操作
    private SetOperations setOperations;

    //针对Map类型操作
    private HashOperations hashOperations;

    //list类型操作
    private ListOperations listOperations;

    public RedisClient() {
        //普通类型
        valueOperations = redisTemplate.opsForValue();
        setOperations = redisTemplate.opsForSet();
        hashOperations = redisTemplate.opsForHash();
        listOperations = redisTemplate.opsForList();
    }

    public ValueOperations getValueOperations() {
        return valueOperations;
    }

    public SetOperations getSetOperations() {
        return setOperations;
    }

    public HashOperations getHashOperations() {
        return hashOperations;
    }

    public ListOperations getListOperations() {
        return listOperations;
    }

    public BoundValueOperations getBoundValueOperations(String tableName) {
        return redisTemplate.boundValueOps(tableName);
    }

    public BoundSetOperations getBoundSetOperations(String tableName) {
        return redisTemplate.boundSetOps(tableName);
    }

    public BoundListOperations getBoundListOperations(String tableName) {
        return redisTemplate.boundListOps(tableName);
    }

    public BoundHashOperations getBoundHashOperations(String tableName) {
        return redisTemplate.boundHashOps(tableName);
    }
}
