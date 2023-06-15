package com.malanau.sensorsapi.sensor.application.search;

import com.malanau.sensorsapi.sensor.application.SensorResponse;
import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorFinder {
    private final SensorRepository repository;

    public SensorResponse find(final String id) {

        return repository.search(new SensorId(id)).map(SensorResponse::fromAggregate).get();
    }
}
