package com.example.redis_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.redis_service.models.KeyValueDocument;

public interface KeyValueRepository extends MongoRepository<KeyValueDocument, String> {
    // Spring Data MongoDB handles basic CRUD automatically
}