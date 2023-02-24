package com.react.java.controller;

import com.react.java.DevUnitTesting;
import com.react.java.ReactCRUDApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ReactCRUDApplication.class)
class EntryControllerTest implements DevUnitTesting {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testLandingApi() {
        HttpStatusCode httpStatusCode = restTemplate.exchange("http://localhost:" + port + "/", HttpMethod.GET, null, HttpStatus.class).getStatusCode();
        assertEquals(HttpStatus.OK.value(), httpStatusCode.value());
    }

}