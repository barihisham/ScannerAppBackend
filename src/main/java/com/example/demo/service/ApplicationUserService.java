package com.example.demo.service;

import com.example.demo.interfaces.ApplicationUserInterface;
import com.example.demo.model.ApplicationUser;
import com.example.demo.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.security.ApplicationUserRole.ADMIN;
import static com.example.demo.security.ApplicationUserRole.USER;

@Service
public class ApplicationUserService implements UserDetailsService, ApplicationUserInterface {


    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserDao, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository
                .findApplicationUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
    }

    @Override
    public ApplicationUser registerUser(@RequestBody ApplicationUser applicationUser) {
        ApplicationUser user =   new ApplicationUser(
                applicationUser.getUsername(),
                passwordEncoder.encode(applicationUser.getPassword()),
                true,
                true,
                true,
                true,
                USER.getGrantedAuthorities()
        );

        return applicationUserRepository.save(user);
    }

    @Override
    public ApplicationUser deleteUser(String applicationUserId) {
        return null;
    }
}
