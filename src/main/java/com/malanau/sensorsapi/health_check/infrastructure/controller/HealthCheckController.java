package com.malanau.sensorsapi.health_check.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class HealthCheckController {

    @GetMapping("/health-check")
    public HashMap<String, String> healthCheckGet() {
        final HashMap<String, String> status = new HashMap<>();
        status.put("application", "sensors-api");
        status.put("status", "ok");

        return status;
    }
}
