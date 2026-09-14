package com.nader.springdemo.student;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable("email") String email) {
        return studentService.findByEmail(email);
    }

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }
    @DeleteMapping("/{email}")
    public void  delete (@PathVariable("/{email}") String email) {
        studentService.delete(studentService.findByEmail(email));
    }


}
