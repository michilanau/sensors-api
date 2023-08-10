package com.malanau.sensorsapi.sensor_counter.domain;

import com.malanau.sensorsapi.shared.domain.IntValueObject;

public final class SensorCounterTotal extends IntValueObject {
    public SensorCounterTotal(final Integer value) {
        super(value);
    }

    public SensorCounterTotal() {
        super(null);
    }

    public static SensorCounterTotal initialize() {
        return new SensorCounterTotal(0);
    }

    public SensorCounterTotal increment() {
        return new SensorCounterTotal(getValue() + 1);
    }
}
