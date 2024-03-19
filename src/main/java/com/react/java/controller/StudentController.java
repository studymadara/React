package com.react.java.controller;

import com.react.java.dao.student.StudentRepository;
import com.react.java.model.Student;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class StudentController {

    StudentRepository studentRepository;

    Counter studentSaveCounter;
    Timer getDataTimer;
    RestTemplate restTemplate;
    @Value("${instance.database.call}")
    boolean isDBCallAllowed;

    @Value("${calling.service.url}")
    String serviceUrl;
    @Value("${calling.service.url2}")
    String serviceUrl2;

    Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentController(StudentRepository studentRepository, MeterRegistry meterRegistry, RestTemplate restTemplate) {
        this.studentRepository = studentRepository;
        this.studentSaveCounter = meterRegistry.counter("student-save");
        this.getDataTimer = meterRegistry.timer("get-data-timer");
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/get/{rollNo}")
//    @Retry(name = Resilience4JConstants.STUDENT_GET, fallbackMethod = "fallBackGetStudent")
//    @CircuitBreaker(name = Resilience4JConstants.STUDENT_GET, fallbackMethod = "")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable String rollNo) {
        if (isDBCallAllowed) {
            return ResponseEntity.ok().body(getDataTimer.record(() -> studentRepository.getStudent(rollNo)));
        } else {
            return getOptionalStudentResponseEntity(rollNo, serviceUrl);
        }
    }

    private ResponseEntity<Optional<Student>> getOptionalStudentResponseEntity(String rollNo, String serviceUrl) {
        //BELOW IS JUST FOR EXPERIMENTING PURPOSE !!!NOT READY FOR PRODUCTION!!!
        log.info("get student call was relayed to another service");
        log.debug("get student with roll no: {} call was relayed to another service ", rollNo);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic dmlyYTp2aXJh");
        HttpEntity<String> httpEntity = new HttpEntity<>("body", headers);

        String url = serviceUrl + "/get/" + rollNo;

        return ResponseEntity.ok().body(getDataTimer.record(() ->
                Optional.ofNullable(restTemplate.exchange(url
                        , HttpMethod.GET
                        , httpEntity
                        , Student.class).getBody())));
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @Timed
    public ResponseEntity<HttpStatus> saveStudent(@RequestBody Student student) {
        studentSaveCounter.increment();
        studentRepository.saveStudent(student);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    public ResponseEntity<Optional<Student>> fallBackGetStudent(String rollNo, Exception exception) {
        log.info("get student called through fallBack mechanism");
        log.debug("get student called through fallBack mechanism for roll no: {}", rollNo);
        return getOptionalStudentResponseEntity(rollNo, serviceUrl2);
    }
}
