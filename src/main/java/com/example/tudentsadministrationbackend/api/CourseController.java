package com.example.tudentsadministrationbackend.api;

import com.example.tudentsadministrationbackend.entity.Course;
import com.example.tudentsadministrationbackend.repositories.ICourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    ICourseRepository courseRepository;

    public CourseController(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Read All functionality
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> index() {
        return ResponseEntity.status(HttpStatus.OK).body(courseRepository.findAll());
    }

    // READ
    @GetMapping("/courses/{id}")
    public Optional<Course> readOne(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // CREATE -> POST
    @PostMapping("/courses")
    public Course create(@RequestBody Course course) {
        Course savedCourse = courseRepository.save(course);
        return savedCourse;
    }

    // UPDATE -> PUT
    @PutMapping("/cars/{id}")
    public Course update(@RequestBody Course course, @PathVariable long id) {
        Course updatedCourse = courseRepository.save(course);
        return updatedCourse;
    }

    // DELETE -> DELETE
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        courseRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
