package com.ppretki.springsecuritydemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @GetMapping(value = "/a/1")
    ResponseEntity<String> getA() {
        log.info("getA()");
        return ResponseEntity.ok("OK");
    }

    @GetMapping(value = "/b/1")
    ResponseEntity<String> getB() {
        log.info("getB()");
        return ResponseEntity.ok("OK");
    }

    @GetMapping(value = "/c/1")
    ResponseEntity<String> getC() {
        log.info("getC()");
        return ResponseEntity.ok("OK");
    }

}
