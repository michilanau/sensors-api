package com.malanau.sensorsapi.sensor_counter.application.increment;

import com.malanau.sensorsapi.sensor.domain.SensorCreatedDomainEvent;
import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.shared.domain.bus.event.DomainEventSubscriber;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@DomainEventSubscriber({SensorCreatedDomainEvent.class})
public final class IncrementSensorCounterOnSensorCreated {
    private final SensorCounterIncrementer incrementer;

    public IncrementSensorCounterOnSensorCreated(final SensorCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(final SensorCreatedDomainEvent event) {
        final SensorId sensorId = new SensorId(event.getAggregateId());

        incrementer.increment(sensorId);
    }
}
