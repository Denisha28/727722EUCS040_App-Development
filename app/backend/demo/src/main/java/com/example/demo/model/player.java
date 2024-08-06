package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class player {
    @Id
    private int plid;
    private String plname;
    private String plemail;
    private String pladdress;
    private long plphno;

}
