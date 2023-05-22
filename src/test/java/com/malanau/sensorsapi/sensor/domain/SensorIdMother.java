package com.malanau.sensorsapi.sensor.domain;

import com.malanau.sensorsapi.shared.domain.UuidMother;

public class SensorIdMother {

    public static SensorId create(final String value) {
        return new SensorId(value);
    }

    public static SensorId random() {
        return create(UuidMother.random());
    }
}
