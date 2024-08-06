package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class courses {
    @Id
    private int csid;
    private String cstitle;
    private String cslevel;
    private String csdescription;
    private String cscouch;

}
