package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.signup;
import com.example.demo.service.signupser;

@RestController
public class signupcont {
     @Autowired
    private signupser signups;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody signup user) {
        Optional<signup> existingUser = signups.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return ResponseEntity.status(409).body("User already exists");
        } else
        {
            signups.saveUser(user);
            return ResponseEntity.ok(user);
        }
        }
    }



