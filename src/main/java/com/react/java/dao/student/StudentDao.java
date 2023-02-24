package com.react.java.dao.student;

import com.react.java.model.Student;

import java.util.Optional;

public interface StudentDao {

    Optional<Student> getStudent(String rollNo);

    void saveStudent(Student student);
}
