package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity

public class plans {
@Id
private Long basic;
private Long standard;
private Long premium;

}
