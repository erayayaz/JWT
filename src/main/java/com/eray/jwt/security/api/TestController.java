package com.eray.jwt.security.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/test")
    public String test() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/public")
    public String publicEndPoint() {
        return "public";
    }
}
