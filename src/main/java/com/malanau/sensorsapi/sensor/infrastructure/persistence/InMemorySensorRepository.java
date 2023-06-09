package com.malanau.sensorsapi.sensor.infrastructure.persistence;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;

import java.util.HashMap;
import java.util.Optional;

public class InMemorySensorRepository implements SensorRepository {
    private final HashMap<String, Sensor> sensors = new HashMap<>();

    @Override
    public void save(final Sensor sensor) {
        sensors.put(sensor.getId().getValue(), sensor);
    }

    @Override
    public Optional<Sensor> search(final SensorId id) {
        return Optional.ofNullable(sensors.get(id.getValue()));
    }
}
