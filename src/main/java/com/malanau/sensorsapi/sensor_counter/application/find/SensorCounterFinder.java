package com.malanau.sensorsapi.sensor_counter.application.find;

import com.malanau.sensorsapi.sensor_counter.domain.SensorCounter;
import com.malanau.sensorsapi.sensor_counter.domain.SensorCounterNotInitialized;
import com.malanau.sensorsapi.sensor_counter.domain.SensorCounterRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public final class SensorCounterFinder {
    private SensorCounterRepository repository;

    public SensorCounterResponse find() {
        final SensorCounter sensorCounter =
                repository
                        .search()
                        .orElseGet(
                                () -> {
                                    throw new SensorCounterNotInitialized();
                                });

        return new SensorCounterResponse(sensorCounter.getTotal().getValue());
    }
}
