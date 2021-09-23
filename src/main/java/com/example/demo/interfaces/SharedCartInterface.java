package com.example.demo.interfaces;

import com.example.demo.model.Product;

import java.util.ArrayList;

public interface SharedCartInterface {
    ArrayList<Product> getSharedCartProducts(String roomId);
}
