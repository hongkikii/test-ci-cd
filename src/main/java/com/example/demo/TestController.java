package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public HttpStatus healthCheck() {
        return HttpStatus.OK;
    }

    @GetMapping("/ver")
    public int getVersion() {
        return 3;
    }

    @GetMapping("/rollback")
    public ResponseEntity<String> rollback() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("BAD_REQUEST");
    }
}
