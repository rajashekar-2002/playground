package com.example.frontend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RedisResponseEvent {

    private String uuid;
    private String key;
    private OperationType operation;
    private String status;
    private String message;
    private LocalDateTime completedAt;
}