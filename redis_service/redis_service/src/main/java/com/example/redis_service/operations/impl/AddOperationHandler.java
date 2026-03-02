package com.example.redis_service.operations.impl;

import com.example.redis_service.dto.RedisEvent;
import com.example.redis_service.operations.RedisOperationHandler;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class AddOperationHandler implements RedisOperationHandler {

    private final StringRedisTemplate redisTemplate;

    public AddOperationHandler(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getOperationType() {
        return "ADD";
    }

    @Override
    public void handle(RedisEvent event) {
        redisTemplate.opsForValue()
                .set(event.getKey(), event.getValue());
    }
}