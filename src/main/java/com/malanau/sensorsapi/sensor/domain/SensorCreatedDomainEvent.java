package com.malanau.sensorsapi.sensor.domain;

import com.malanau.sensorsapi.shared.domain.bus.event.DomainEvent;

import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class SensorCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final Long timestamp;

    public SensorCreatedDomainEvent() {
        super(null);

        name = null;
        timestamp = null;
    }

    public SensorCreatedDomainEvent(
            final String aggregateId, final String name, final Long timestamp) {
        super(aggregateId);

        this.name = name;
        this.timestamp = timestamp;
    }

    public SensorCreatedDomainEvent(
            final String aggregateId,
            final String eventId,
            final String occurredOn,
            final String name,
            final Long timestamp) {
        super(aggregateId, eventId, occurredOn);

        this.name = name;
        this.timestamp = timestamp;
    }

    @Override
    public String eventName() {
        return "sensor.created";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final SensorCreatedDomainEvent that)) {
            return false;
        }
        return Objects.equals(name, that.name) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timestamp);
    }
}
