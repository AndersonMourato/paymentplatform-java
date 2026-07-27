package com.paymentplatform.platform.adapter.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/architecture")
public class ArchitectureHealthController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("hexagonal-ready");
    }
}