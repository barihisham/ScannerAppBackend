package com.example.demo.repository;

import com.example.demo.model.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends MongoRepository<ShoppingList, String> {
    List<ShoppingList> findShoppingListByOwner(String username);
}
