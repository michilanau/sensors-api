package com.malanau.sensorsapi.sensor.domain.humidity;

import com.malanau.sensorsapi.sensor.domain.SensorCreatedDomainEvent;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

@Getter
public class HumiditySensorCreatedDomainEvent extends SensorCreatedDomainEvent {

    private final Double value;

    public HumiditySensorCreatedDomainEvent() {
        super();

        value = null;
    }

    public HumiditySensorCreatedDomainEvent(
            final String aggregateId, final String name, final Long timestamp, final Double value) {
        super(aggregateId, name, timestamp);

        this.value = value;
    }

    public HumiditySensorCreatedDomainEvent(
            final String aggregateId,
            final String eventId,
            final String occurredOn,
            final String name,
            final Long timestamp,
            final Double value) {
        super(aggregateId, eventId, occurredOn, name, timestamp);

        this.value = value;
    }

    @Override
    public HumiditySensorCreatedDomainEvent fromPrimitives(
            final String aggregateId,
            final HashMap<String, Serializable> body,
            final String eventId,
            final String occurredOn) {
        return new HumiditySensorCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (Long) body.get("timestamp"),
                (Double) body.get("value"));
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {
            @Serial private static final long serialVersionUID = 8454082948357103709L;

            {
                put("name", getName());
                put("timestamp", getTimestamp());
                put("value", getValue());
            }
        };
    }
}
