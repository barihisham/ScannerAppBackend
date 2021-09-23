package com.example.demo.interfaces;

import com.example.demo.model.ApplicationUser;

public interface ApplicationUserInterface {
    ApplicationUser registerUser(ApplicationUser applicationUser);
    ApplicationUser deleteUser(String applicationUserId);
}
