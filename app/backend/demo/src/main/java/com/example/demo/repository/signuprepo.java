package com.example.demo.repository;

import java.util.Optional; // Correct import statement for Optional
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.signup;

 // Correct class name

@Repository
public interface signuprepo extends JpaRepository<signup, Integer> {
    Optional<signup> findByEmail(String email);
}
