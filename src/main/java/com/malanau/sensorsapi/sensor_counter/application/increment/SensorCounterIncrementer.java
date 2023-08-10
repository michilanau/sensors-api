package com.malanau.sensorsapi.sensor_counter.application.increment;

import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.sensor_counter.domain.SensorCounter;
import com.malanau.sensorsapi.sensor_counter.domain.SensorCounterRepository;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class SensorCounterIncrementer {
    private final SensorCounterRepository repository;

    public SensorCounterIncrementer(final SensorCounterRepository repository) {
        this.repository = repository;
    }

    public void increment(final SensorId id) {

        final SensorCounter counter =
                repository
                        .search()
                        .orElseGet(() -> SensorCounter.initialize(UUID.randomUUID().toString()));

        counter.increment(id);
        repository.save(counter);
    }
}
