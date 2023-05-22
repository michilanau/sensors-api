package com.malanau.sensorsapi.sensor.infrastructure.controller;

import com.malanau.sensorsapi.sensor.application.create.CreateSensorRequest;
import com.malanau.sensorsapi.sensor.application.create.SensorCreator;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public final class SensorController {

    private final SensorCreator sensorCreator;

    @PostMapping("/sensor")
    public ResponseEntity<String> create(@RequestBody final CreateSensorRequest request) {
        sensorCreator.create(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
