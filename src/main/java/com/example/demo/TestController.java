package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // health check api: 정상/예외 응답 경우에 따라 트래픽을 새로운 서비스로 돌릴지 말지 결정
    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
       return ResponseEntity.ok("OK");
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                // .body("BAD_REQUEST");
    }

    // 애플리케이션 버전 확인 api: 테스트때마다 +1
    @GetMapping("/ver")
    public int getVersion() {
        return 13;
    }

    // rollback api: 정상/예외 응답 경우에 따라 다시 기존 서비스로 롤백시킬지를 결정
    @GetMapping("/rollback")
    public ResponseEntity<String> rollback() {
       // return ResponseEntity.ok("OK");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("BAD_REQUEST");
    }
}
