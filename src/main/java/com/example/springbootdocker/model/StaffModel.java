package com.example.springbootdocker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "staffInfo")
public class StaffModel {
    @Id
    private int id;
    private String email;
    private String phone;
    private String password;
    private String position;
}
