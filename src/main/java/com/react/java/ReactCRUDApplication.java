package com.react.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReactCRUDApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactCRUDApplication.class, args);
    }
}
