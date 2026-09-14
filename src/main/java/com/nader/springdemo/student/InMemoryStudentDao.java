package com.nader.springdemo.student;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Repository
public class InMemoryStudentDao {
    private final static List<Student> STUDENTS = new ArrayList<Student>();
    public Student save(Student s) {
        STUDENTS.add(s);
        return s;
    }

    public List<Student> findAll() {
        return STUDENTS;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public void delete(String email) {
        var studentIndex = findByEmail(email);
        if (studentIndex != null) {
            STUDENTS.remove(studentIndex);
        }
    }

    public Student update(Student s) {
        var studentInex = IntStream.range(0, STUDENTS.size())
                .filter(i -> STUDENTS.get(i).getEmail().equals(s.getEmail()))
                .findFirst().orElse(-1);
        if (studentInex != -1) {
            STUDENTS.set(studentInex, s);
            return s;
        }
        return null;
    }
}
