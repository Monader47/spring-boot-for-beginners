package com.nader.springdemo.student;
import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> findAll() {
        return List.of(
                new Student(
                        "Mohamed",
                        "Nader",
                        LocalDate.now(),
                        "m@123",
                        33
                ),
                new Student(
                        "Mohamed",
                        "ali",
                        LocalDate.now(),
                        "maliiiiiiii@123",
                        3
                )
        );
    }
}


