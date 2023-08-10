package com.malanau.sensorsapi.sensor_counter.domain;

import java.util.Optional;

public interface SensorCounterRepository {
    void save(SensorCounter counter);

    Optional<SensorCounter> search();
}
