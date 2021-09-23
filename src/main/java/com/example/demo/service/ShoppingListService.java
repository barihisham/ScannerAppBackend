package com.example.demo.service;

import com.example.demo.interfaces.ShoppingListInterface;
import com.example.demo.model.ShoppingList;
import com.example.demo.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingListService implements ShoppingListInterface {

    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(new ShoppingList(shoppingList.getOwner(),
                shoppingList.getShoppingListName(),
                new Date()));
    }

    @Override
    public ShoppingList updateShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    @Override
    public List<ShoppingList> getAllShoppingLists(String username) {
        return shoppingListRepository.findShoppingListByOwner(username);
    }

    @Override
    public String deleteShoppingList(String shoppingListId) {
        shoppingListRepository.deleteById(shoppingListId);
        return shoppingListId;
    }


}
