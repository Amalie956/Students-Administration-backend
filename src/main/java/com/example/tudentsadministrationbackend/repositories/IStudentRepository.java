package com.example.tudentsadministrationbackend.repositories;

import com.example.tudentsadministrationbackend.entity.Course;
import com.example.tudentsadministrationbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
