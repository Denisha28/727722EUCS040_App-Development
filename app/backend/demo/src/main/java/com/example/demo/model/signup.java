package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data

public class signup {
    @Id
    private int id;
    private String email;
    private String password;
    private String confirmpassword;
}
