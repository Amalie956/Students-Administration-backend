package com.example.tudentsadministrationbackend.api;

import com.example.tudentsadministrationbackend.entity.Course;
import com.example.tudentsadministrationbackend.entity.Student;
import com.example.tudentsadministrationbackend.repositories.ICourseRepository;
import com.example.tudentsadministrationbackend.repositories.IStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    IStudentRepository studentRepository;
    ICourseRepository courseRepository;

    public StudentController(IStudentRepository studentRepository, ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Read All functionality
    @GetMapping("/students")
    public ResponseEntity<List<Course>> index() {
        return ResponseEntity.status(HttpStatus.OK).body(courseRepository.findAll());
    }

    // READ
    @GetMapping("/students/{id}")
    public Optional<Student> readOne(@PathVariable long id) {
        return studentRepository.findById(id);
    }

    // CREATE -> POST
    @PostMapping("/students")
    public Student create(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    // UPDATE -> PUT
    @PutMapping("/students/{studentId}/addCourse/{courseId}")
    public ResponseEntity<Student> addCourseToStudent(@PathVariable long studentId, @PathVariable long courseId) {
        // Finder den studerende med det givne ID i databasen
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        // Finder kurset med det givne ID i databasen
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        // Tjekker om både den studerende og kurset blev fundet i databasen
        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            // Hvis begge blev fundet, henter vi den studerende og kurset fra Optional-objekterne
            Student student = studentOptional.get();
            Course course = courseOptional.get();

            // Bruger enrollStudent-metoden til at tilføje kurset til den studerendes kursusliste
            student.enrollStudent(course);

            // Gemmer den opdaterede studerende i databasen
            studentRepository.save(student);

            // Returner den opdaterede studerende og en HTTP-statuskode OK
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            // Hvis enten den studerende eller kurset ikke blev fundet, returnerer vi en HTTP-statuskode NOT FOUND
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    // DELETE -> DELETE
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
