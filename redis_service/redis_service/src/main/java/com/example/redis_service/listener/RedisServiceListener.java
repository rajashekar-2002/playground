package com.example.redis_service.listener;

import com.example.redis_service.dto.RedisEvent;
import com.example.redis_service.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceListener {

    private final RabbitTemplate rabbitTemplate;

    public RedisServiceListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @KafkaListener(topics = "redis_opr_request_topic", groupId = "redis-service-group")
    public void listen(RedisEvent event) {

        System.out.println("Received from Kafka:-------------------------------------------- " + event);

        // Send to Redis worker queue
        rabbitTemplate.convertAndSend(RabbitConfig.REDIS_QUEUE, event);

        // Send to Mongo worker queue
        rabbitTemplate.convertAndSend(RabbitConfig.MONGO_QUEUE, event);
    }
}