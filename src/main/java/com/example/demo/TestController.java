package com.example.demo;

import org.springframework.http.HttpStatus;
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
        return 2;
    }

    @GetMapping("/rollback")
    public HttpStatus rollback() {
        return HttpStatus.BAD_REQUEST;
    }
}
