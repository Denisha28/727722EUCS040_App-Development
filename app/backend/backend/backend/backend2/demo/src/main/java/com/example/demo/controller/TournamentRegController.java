package com.example.demo.controller;

import com.example.demo.model.TournamentReg;
import com.example.demo.service.TournamentRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentRegController {

    @Autowired
    private TournamentRegService tournamentRegService;

    @GetMapping
    public List<TournamentReg> getAllRegistrations() {
        return tournamentRegService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentReg> getRegistrationById(@PathVariable String id) {
        Optional<TournamentReg> registration = tournamentRegService.getRegistrationById(id);
        return registration.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TournamentReg createRegistration(@RequestBody TournamentReg tournamentReg) {
        return tournamentRegService.createOrUpdateRegistration(tournamentReg);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TournamentReg> updateRegistration(@PathVariable String id, @RequestBody TournamentReg tournamentReg) {
        if (tournamentRegService.getRegistrationById(id).isPresent()) {
            tournamentReg.setTid(id);
            return ResponseEntity.ok(tournamentRegService.createOrUpdateRegistration(tournamentReg));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable String id) {
        if (tournamentRegService.getRegistrationById(id).isPresent()) {
            tournamentRegService.deleteRegistration(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
