// src/main/java/com/example/demo/controller/logincont.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.signupser;
import com.example.demo.model.signup;
import java.util.Optional;

@RestController
public class logincont {

    @Autowired
    private signupser logins;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody signup loginRequest) {
        Optional<signup> userOptional = logins.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            signup user = userOptional.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}
