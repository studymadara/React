package com.react.java.controller;

import com.react.java.dao.StudentRepository;
import com.react.java.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @Value(value = "${local.server.port}")
    private int port;

    @MockBean
    StudentRepository studentRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testGetStudent() {
        String rollNo = "12";
        Student expected = Student.builder().studentRollNo(rollNo).studentName("Raj Test").studentClass("12th").id(UUID.randomUUID().toString()).build();
        Mockito.when(studentRepository.getStudent(rollNo)).thenReturn(Optional.of(expected));

        Student student = restTemplate.exchange("http://localhost:" + port + "/get/" + rollNo, HttpMethod.GET, null, Student.class).getBody();

        Assertions.assertEquals(student, expected);
    }
}