package com.nader.springdemo.student;
import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;

public interface StudentService {
    Student save(Student s);
    public List<Student> findAll() ;
    Student findByEmail(String email);
    void delete(Student s);


    Student update(Student s);


}


