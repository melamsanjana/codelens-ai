package com.codelens.backend.service;

import com.codelens.backend.entity.User;
import com.codelens.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register User
    public User registerUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Encrypt Password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // Login User
    public User loginUser(String email, String password) {

    System.out.println("========== LOGIN ==========");
    System.out.println("Email Received: " + email);
    System.out.println("Password Received: " + password);

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    System.out.println("User Found: " + user.getEmail());
    System.out.println("Stored Password: " + user.getPassword());

    boolean matched = passwordEncoder.matches(password, user.getPassword());

    System.out.println("Password Matched: " + matched);

    if (!matched) {
        throw new RuntimeException("Invalid password");
    }

    return user;
}

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User By ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}