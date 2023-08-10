package com.malanau.sensorsapi.sensor_counter.domain;

import com.malanau.sensorsapi.shared.domain.UUIDIdentifier;

public final class SensorCounterId extends UUIDIdentifier {

    public SensorCounterId(final String value) {
        super(value);
    }

    public SensorCounterId() {}
}
