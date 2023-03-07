package com.react.java.controller;

import com.react.java.DevUnitTesting;
import com.react.java.dao.student.StudentRepository;
import com.react.java.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest implements DevUnitTesting {
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
    @Disabled
    void testGetStudent() {
        String rollNo = "12";
        Student expected = Student.builder().studentRollNo(rollNo).studentName("Raj Test").studentClass("12th").build();
        Mockito.when(studentRepository.getStudent(rollNo)).thenReturn(Optional.of(expected));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic dmlyYTp2aXJh");
        HttpEntity<String> httpEntity = new HttpEntity<>("body", headers);

        Student student = restTemplate
                .exchange("http://localhost:" + port + "/get/" + rollNo, HttpMethod.GET, httpEntity, Student.class).getBody();

        Assertions.assertEquals(expected, student);
    }
}