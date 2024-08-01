package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data

public class signup {
    private String email;
    private String password;
    private String confirmpassword;
}
