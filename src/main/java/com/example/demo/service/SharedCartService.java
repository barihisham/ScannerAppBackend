package com.example.demo.service;

import com.example.demo.interfaces.SharedCartInterface;
import com.example.demo.model.Product;
import com.example.demo.model.SharedCart;
import com.example.demo.repository.SharedCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SharedCartService implements SharedCartInterface {
    private final SharedCartRepository sharedCartRepo;

    @Autowired
    public SharedCartService(SharedCartRepository sharedCartRepo){
        this.sharedCartRepo = sharedCartRepo;
    }

    @Override
    public ArrayList<Product> getSharedCartProducts(String cartId) {
        Optional<SharedCart> productList = sharedCartRepo.findById(cartId);
        if(productList.isPresent()){
            return productList.get().getProductList();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    public void addToSharedCart(String cartId, Product item){
        Optional<SharedCart> cart = sharedCartRepo.findById(cartId);
        cart.get().getProductList().add(item);
        sharedCartRepo.save(cart.get());
    }

    public String getSharedCartId(String owner){
        return sharedCartRepo.findCartIdByOwner(owner);
    }

    public String createSharedCart(String owner){
        return sharedCartRepo.save(new SharedCart(owner, new ArrayList<Product>())).getCartId();
    }
}
