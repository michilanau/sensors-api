package com.malanau.sensorsapi.sensor.domain;

import com.malanau.sensorsapi.shared.domain.UUIDIdentifier;

public final class SensorId extends UUIDIdentifier {

    public SensorId(final String value) {
        super(value);
    }

    public SensorId() {
        super(null);
    }
}
