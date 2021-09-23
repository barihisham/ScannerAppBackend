package com.example.demo.repository;

import com.example.demo.model.SharedCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SharedCartRepository extends MongoRepository<SharedCart, String> {
    String findCartIdByOwner(String owner);
}
