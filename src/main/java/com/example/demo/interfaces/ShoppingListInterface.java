package com.example.demo.interfaces;

import com.example.demo.model.ShoppingList;

import java.util.List;

public interface ShoppingListInterface {
    ShoppingList createShoppingList(ShoppingList shoppingList);
    ShoppingList updateShoppingList(ShoppingList shoppingList);
    List<ShoppingList> getAllShoppingLists(String username);
    String deleteShoppingList(String shoppingListId);
}
