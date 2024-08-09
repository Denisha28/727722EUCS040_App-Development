package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class TournamentReg {
    @Id
    private String tid;
    private String tname;
    private String pname;
    private String email;
    private String location;
    private String date;

}
