package dev.jiwonlee.remoteserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jiwonlee.remoteserver.service.RemoteService;

@CrossOrigin("*")
@RestController
public class RemoteController {

    private RemoteService remoteService;

    @Autowired
    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;

    }

    @GetMapping("/")
    public ResponseEntity remote() throws Exception {
        return ResponseEntity.ok().body(remoteService.test());
    }
}
