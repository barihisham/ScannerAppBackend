package com.example.demo.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class SharedCart {
    @Id
    private String cartId;
    @Indexed(unique = true, sparse = true)
    private String owner;
    private ArrayList<Product> productList;

    public SharedCart(String owner, ArrayList<Product> productList) {
        this.owner = owner;
        this.productList = productList;
    }
}
