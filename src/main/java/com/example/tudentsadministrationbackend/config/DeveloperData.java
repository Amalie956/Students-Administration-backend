package com.example.tudentsadministrationbackend.config;

import com.example.tudentsadministrationbackend.entity.Course;
import com.example.tudentsadministrationbackend.entity.Student;
import com.example.tudentsadministrationbackend.repositories.ICourseRepository;
import com.example.tudentsadministrationbackend.repositories.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DeveloperData implements CommandLineRunner {
    ICourseRepository courseRepository;
    IStudentRepository studentRepository;

    public DeveloperData(ICourseRepository courseRepository, IStudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseRepository.save(new Course("Matematik"));
        courseRepository.save(new Course("Dansk"));
        courseRepository.save(new Course("Engelsk"));
        courseRepository.save(new Course("Historie"));
        courseRepository.save(new Course("Samfundsfag"));

        studentRepository.save(new Student("Amalie"));
        studentRepository.save(new Student("Julie"));
        studentRepository.save(new Student("Jens"));
        studentRepository.save(new Student("Kasper"));
        studentRepository.save(new Student("Henriette"));
    }
}
