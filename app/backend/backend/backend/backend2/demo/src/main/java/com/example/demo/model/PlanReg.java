package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class PlanReg {
@Id
private String name;
private String email;
private String password;
private String plan;

}
