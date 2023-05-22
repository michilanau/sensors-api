package com.malanau.sensorsapi.sensor.infrastructure.persistence;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class InMemorySensorRepository implements SensorRepository {
    private final HashMap<String, Sensor> sensors = new HashMap<>();

    @Override
    public void save(final Sensor sensor) {
        sensors.put(sensor.getId().value(), sensor);
    }

    @Override
    public Optional<Sensor> search(final SensorId id) {
        return Optional.ofNullable(sensors.get(id.value()));
    }
}
