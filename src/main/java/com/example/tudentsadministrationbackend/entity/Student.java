package com.example.tudentsadministrationbackend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "Student", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Empty constructor
    public Student() {
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for courses
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Opgave 2 - tilmeld den studerende til et kursus:
    public void enrollStudent(Course course){
        courses.add(course);
    }
}
