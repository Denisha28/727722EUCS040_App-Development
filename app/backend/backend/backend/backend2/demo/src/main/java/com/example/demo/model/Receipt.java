package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity

public class Receipt {
@Id
private String date;
private String name;
private String email;
private String plan;
private Long cardno;
private String expdate;
private String nameoncard;
}
