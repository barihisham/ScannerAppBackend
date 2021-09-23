package com.example.demo.controller;

import com.example.demo.model.ApplicationUser;
import com.example.demo.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @RequestMapping("/register")
    @PostMapping
    public ApplicationUser registerUser(@RequestBody ApplicationUser applicationUser){
        return applicationUserService.registerUser(applicationUser);
    }
}
