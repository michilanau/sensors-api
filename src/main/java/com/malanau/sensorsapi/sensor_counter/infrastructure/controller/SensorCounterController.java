package com.malanau.sensorsapi.sensor_counter.infrastructure.controller;

import com.malanau.sensorsapi.sensor_counter.application.find.SensorCounterFinder;
import com.malanau.sensorsapi.sensor_counter.application.find.SensorCounterResponse;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SensorCounterController {

    SensorCounterFinder sensorCounterFinder;

    @GetMapping("/sensor-counter")
    public ResponseEntity<SensorCounterResponse> findSensorCounter() {
        final SensorCounterResponse sensorCounterResponse = sensorCounterFinder.find();

        return ResponseEntity.ok().body(sensorCounterResponse);
    }
}
