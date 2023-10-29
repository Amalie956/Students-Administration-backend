package com.example.tudentsadministrationbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;

    // Empty constructor
    public Student() {
    }
}
