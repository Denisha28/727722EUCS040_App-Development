package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.tournaments;

public interface tournamentsrepo extends JpaRepository<tournaments,Integer>{

}
