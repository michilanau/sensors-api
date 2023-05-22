package com.malanau.sensorsapi.sensor.domain;

import com.malanau.sensorsapi.shared.domain.StringValueObject;

public class SensorName extends StringValueObject {

    public SensorName(final String sensorName) {
        super(sensorName);
    }

    public SensorName() {
        super(null);
    }
}
