package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.login;
@Repository
public interface loginrepo extends JpaRepository<login,Integer> {
    Optional<login> findByemail(String email);

}
