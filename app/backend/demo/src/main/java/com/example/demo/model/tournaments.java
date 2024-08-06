package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class tournaments {
@Id
private int tid;
private String tname;
private String tdate;
private String tlocation;
private int organizerid;
private String time;
}
