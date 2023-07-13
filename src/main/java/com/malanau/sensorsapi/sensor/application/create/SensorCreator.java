package com.malanau.sensorsapi.sensor.application.create;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;
import com.malanau.sensorsapi.shared.domain.bus.event.EventBus;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SensorCreator {
    private final SensorRepository repository;
    private final EventBus eventBus;

    public void create(final CreateSensorRequest createSensorRequest) {

        for (final Sensor sensor : createSensorRequest.getSensors()) {

            sensor.recordEvent();
            repository.save(sensor);
            eventBus.publish(sensor.pullDomainEvents());
        }
    }
}
