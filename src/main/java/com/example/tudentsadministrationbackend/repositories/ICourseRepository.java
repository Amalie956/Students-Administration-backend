package com.example.tudentsadministrationbackend.repositories;

import com.example.tudentsadministrationbackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
