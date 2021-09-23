package com.example.demo.repository;

import com.example.demo.model.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
    Optional<ApplicationUser> findApplicationUserByUsername(String username);
}
