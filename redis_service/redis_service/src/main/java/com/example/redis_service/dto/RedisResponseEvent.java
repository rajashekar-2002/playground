package com.example.redis_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RedisResponseEvent {

    private String uuid;
    private String key;
    private String operation;
    private String status; // SUCCESS / FAILED
    private String message;
    private LocalDateTime completedAt;

    public RedisResponseEvent() {
    }

    public RedisResponseEvent(String uuid,
            String key,
            String operation,
            String status,
            String message,
            LocalDateTime completedAt) {
        this.uuid = uuid;
        this.key = key;
        this.operation = operation;
        this.status = status;
        this.message = message;
        this.completedAt = completedAt;
    }

    // getters + setters
}