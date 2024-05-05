package com.example.springbootdocker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
public class StaffModel {
    @Id
    private int id;
    private String email;
    private String phone;
    private String password;
    private String position;
}
