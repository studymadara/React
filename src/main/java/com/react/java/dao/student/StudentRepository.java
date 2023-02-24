package com.react.java.dao.student;

import com.react.java.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentRepository {

    private final StudentDaoDynamo studentDaoDynamo;

    StudentRepository(StudentDaoDynamo studentDaoDynamo) {
        this.studentDaoDynamo = studentDaoDynamo;
    }

    public Optional<Student> getStudent(String rollNo) {
        return studentDaoDynamo.getStudent(rollNo);
    }

    public void saveStudent(Student student) {
        studentDaoDynamo.saveStudent(student);
    }
}
