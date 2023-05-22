package com.malanau.sensorsapi.sensor.domain;

import java.util.Optional;

public interface SensorRepository {

    void save(Sensor sensor);

    Optional<Sensor> search(final SensorId id);
}
