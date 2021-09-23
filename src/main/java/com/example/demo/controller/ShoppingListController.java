package com.example.demo.controller;

import com.example.demo.model.ShoppingList;
import com.example.demo.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shoppinglist")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping
    public List<ShoppingList> getAllShoppingLists(String owner){
        return shoppingListService.getAllShoppingLists(owner);
    }

    @PostMapping
    public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList){
        return shoppingListService.createShoppingList(shoppingList);
    }

    @PutMapping
    public ShoppingList updateShoppingList(@RequestBody ShoppingList shoppingList){
        return shoppingListService.updateShoppingList(shoppingList);
    }

    @DeleteMapping
    public String deleteShoppingList(String shoppingListId){
        return shoppingListService.deleteShoppingList(shoppingListId);
    }
}
