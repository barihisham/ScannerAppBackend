package com.example.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingList {


    @Id
    private String id;
    private String shoppingListName;
    private List<String> items;
    private String owner;
    private List<String> collaborators;
    private Date createdAt;

    public ShoppingList(String owner, String shoppingListName, Date createAt) {
        this.shoppingListName = shoppingListName;
        this.owner = owner;
        this.createdAt = createAt;
    }
}
