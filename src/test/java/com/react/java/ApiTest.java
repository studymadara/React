package com.react.java;

import com.react.java.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTest {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {

    }

    @Test
    @Disabled(value = "Will enable once docker is integrated with tests as well")
    void testGetStudent() {
        Student student = restTemplate.exchange("http://localhost:" + port + "/get/12", HttpMethod.GET, null, Student.class).getBody();
        assertNull(student);
    }
}
