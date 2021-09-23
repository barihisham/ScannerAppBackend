package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.SharedCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/sharedcart")
public class SharedCartController {
    private SharedCartService sharedCartServ;

    @Autowired
    public SharedCartController(SharedCartService sharedCartServ){
        this.sharedCartServ = sharedCartServ;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<?> createSharedCart(String owner){
        try{
            String cartId = sharedCartServ.createSharedCart(owner);
            return new ResponseEntity<>(cartId, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public @ResponseBody ResponseEntity<?> getSharedCartProducts(String cartId){
        try{
            ArrayList<Product> list = sharedCartServ.getSharedCartProducts(cartId);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @RequestMapping("/api/v1/sharedcart/getid")
    public @ResponseBody ResponseEntity<?> getSharedCartId(String owner){
        try {
            String cartId = sharedCartServ.getSharedCartId(owner);
            return new ResponseEntity<>(cartId, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
