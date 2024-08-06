// src/main/java/com/example/demo/service/loginser.java
package com.example.demo.service;

import com.example.demo.model.login;
import com.example.demo.repository.loginrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class loginser {

    @Autowired
    private loginrepo loginRepo;

    public Optional<login> findByEmail(String email) {
        return loginRepo.findByemail(email);
    }

    public void saveUser(login user) {
        loginRepo.save(user);
    }
}
