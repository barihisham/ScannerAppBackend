package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.ProductBarcode;
import com.example.demo.service.SharedCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class SocketController {
    //Tar emot en streckkod, hämtar produkten och broadcastar sedan till alla som subscribear till rummet
    //Behöver hantera exceptions
    @Autowired
    private SharedCartService service;

    public SocketController(SharedCartService service){
        this.service = service;
    }

    @MessageMapping("/{username}/{room}")
    @SendTo("/output/{username}/{room}")
    public String shareProduct(@DestinationVariable String username, @DestinationVariable String room, ProductBarcode item) throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://scannieboi2.herokuapp.com/getproduct?barcode="+item.getBarcode()))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        service.addToSharedCart(room, new Product());
        return response.body();
    }
}
