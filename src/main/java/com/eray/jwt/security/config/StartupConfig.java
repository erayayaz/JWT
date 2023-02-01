package com.eray.jwt.security.config;

import com.eray.jwt.security.model.Role;
import com.eray.jwt.security.model.User;
import com.eray.jwt.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements CommandLineRunner {

    private final UserService userService;

    public StartupConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createUser(new User(1, "erayayaz", "12345", "eray@gmail.com", Role.USER));
        userService.createUser(new User(2, "erayayaz2", "123456", "eray2@gmail.com", Role.ADMIN));

    }
}
