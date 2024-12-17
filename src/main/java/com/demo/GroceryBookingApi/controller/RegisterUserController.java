package com.demo.GroceryBookingApi.controller;

import com.demo.GroceryBookingApi.entity.UserInfo;
import com.demo.GroceryBookingApi.repo.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterUserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterUserController(UserRepository userRepo, PasswordEncoder pswdEncoder) {
        this.userRepository = userRepo;
        this.passwordEncoder = pswdEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserInfo user) {
        try {
            String hash = passwordEncoder.encode(user.getPwd());
            user.setPwd(hash);
            UserInfo savedCustomer = userRepository.save(user);
            if (savedCustomer.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED.value()).body(
                        "User Details saved successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY.value()).body(
                        "User Registration failed");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(
                    "An Exception occurred" + ex.getMessage());
        }

    }
}
