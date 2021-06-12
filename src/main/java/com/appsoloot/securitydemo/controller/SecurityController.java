package com.appsoloot.securitydemo.controller;

import com.appsoloot.securitydemo.model.User;
import com.appsoloot.securitydemo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SecurityController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SecurityController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public void registerUser(@RequestParam Map<String, String> requestParams) {
        User user = new User();
        user.setName(requestParams.get("username"));
        user.setPassword(passwordEncoder.encode(requestParams.get("password")));
        userService.save(user);
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }
}
