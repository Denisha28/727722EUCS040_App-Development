package com.example.demo.repository;

import com.example.demo.model.TournamentReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRegRepository extends JpaRepository<TournamentReg, String> {

}
