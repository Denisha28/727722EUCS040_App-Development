package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.signup;
import com.example.demo.repository.signuprepo;

@Service
public class signupser {
    @Autowired
    private signuprepo signups;

    public Optional<signup> findByEmail(String email) {
        return signups.findByEmail(email);
    }

    public void saveUser(signup user) {
        signups.save(user);
    }

}
