package com.codelens.backend.controller;

import com.codelens.backend.dto.LoginRequest;
import com.codelens.backend.entity.User;
import com.codelens.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Register User
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        user.setId(null);
        user.setCreatedAt(null);
        return userService.registerUser(user);
    }

    // Login User
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );
    }

    // Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User By ID
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}