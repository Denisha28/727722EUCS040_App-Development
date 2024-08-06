package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class coaches {
    @Id
    private int chid;
    private String chname;
    private long chphno;
    private String chemail;
    private String chaddress;
    private String chspecilization;

}
