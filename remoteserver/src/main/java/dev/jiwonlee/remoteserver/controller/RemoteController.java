package dev.jiwonlee.remoteserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jiwonlee.remoteserver.service.RemoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class RemoteController {

    private final RemoteService remoteService;

    @GetMapping("/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/test")
    public ResponseEntity<String> remote() throws Exception {
        return ResponseEntity.ok().body(remoteService.test());
    }
}
