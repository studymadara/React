package com.react.java.dao.student;

import com.react.java.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentRepository {

    private final StudentDaoDynamo studentDaoDynamo;

    StudentRepository(StudentDaoDynamo studentDaoDynamo) {
        this.studentDaoDynamo = studentDaoDynamo;
    }

    Logger log = LoggerFactory.getLogger(StudentRepository.class);

    public Optional<Student> getStudent(String rollNo) {
        log.info("get student was called");
        log.debug("student with {} was called", rollNo);
        return studentDaoDynamo.getStudent(rollNo);
    }

    public void saveStudent(Student student) {
        log.info("student was saved");
        log.debug("student was saved with details : {}", student);
        studentDaoDynamo.saveStudent(student);
    }
}
