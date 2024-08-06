package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class admin {
    @Id
    private int aid;
    private String aname;
    private String adescription;
    private String atime;
    private int achid;

}
