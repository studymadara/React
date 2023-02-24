package com.react.java.controller;

import com.react.java.dao.student.StudentRepository;
import com.react.java.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(path = "/get/{rollNo}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable String rollNo) {
        return ResponseEntity.ok().body(studentRepository.getStudent(rollNo));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<HttpStatus> getStudent(@RequestAttribute Student student) {
        studentRepository.saveStudent(student);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
