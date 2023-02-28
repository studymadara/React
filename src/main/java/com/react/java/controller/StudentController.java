package com.react.java.controller;

import com.react.java.dao.student.StudentRepository;
import com.react.java.model.Student;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {

    StudentRepository studentRepository;

    Counter studentSaveCounter;
    Timer getDataTimer;

    @Autowired
    StudentController(StudentRepository studentRepository, MeterRegistry meterRegistry) {
        this.studentRepository = studentRepository;
        this.studentSaveCounter = meterRegistry.counter("student-save");
        this.getDataTimer = meterRegistry.timer("get-data-timer");
    }

    @GetMapping(path = "/get/{rollNo}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable String rollNo) {
        return ResponseEntity.ok().body(getDataTimer.record(() -> studentRepository.getStudent(rollNo)));
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Timed
    public ResponseEntity<HttpStatus> saveStudent(@RequestBody Student student) {
        studentSaveCounter.increment();
        studentRepository.saveStudent(student);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
