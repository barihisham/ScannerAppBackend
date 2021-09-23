package com.example.demo;
import com.example.demo.model.ApplicationUser;
import com.example.demo.repository.ApplicationUserRepository;
import com.example.demo.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {

/*    @Autowired
    private ApplicationUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostConstruct
    public void initUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "bari",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true,
                        ApplicationUserRole.ADMIN.getGrantedAuthorities()
                ),
                new ApplicationUser(
                        "tom",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true,
                        ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities()
                )
        );
        userRepository.saveAll(applicationUsers);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
