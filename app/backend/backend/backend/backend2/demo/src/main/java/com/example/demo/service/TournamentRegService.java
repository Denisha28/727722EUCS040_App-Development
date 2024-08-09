package com.example.demo.service;

import com.example.demo.model.TournamentReg;
import com.example.demo.repository.TournamentRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentRegService {

    @Autowired
    private TournamentRegRepository tournamentRegRepository;

    public List<TournamentReg> getAllRegistrations() {
        return tournamentRegRepository.findAll();
    }

    public Optional<TournamentReg> getRegistrationById(String id) {
        return tournamentRegRepository.findById(id);
    }

    public TournamentReg createOrUpdateRegistration(TournamentReg tournamentReg) {
        return tournamentRegRepository.save(tournamentReg);
    }

    public void deleteRegistration(String id) {
        tournamentRegRepository.deleteById(id);
    }
}
