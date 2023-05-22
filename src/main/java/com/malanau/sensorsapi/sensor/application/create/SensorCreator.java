package com.malanau.sensorsapi.sensor.application.create;

import com.malanau.sensorsapi.sensor.domain.SensorRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorCreator {
    private final SensorRepository repository;

    public void create(final CreateSensorRequest createSensorRequest) {

        repository.save(createSensorRequest.getSensor());
    }
}
