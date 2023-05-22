package com.malanau.sensorsapi.sensor.domain;

import com.malanau.sensorsapi.shared.domain.UuidMother;

public class SensorNameMother {
    public static SensorName create(final String value) {
        return new SensorName(value);
    }

    public static SensorName random() {
        return create(UuidMother.random());
    }
}
