package com.malanau.sensorsapi.sensor.domain.humidity;

import com.malanau.sensorsapi.shared.domain.DoubleValueObject;

public class HumiditySensorValue extends DoubleValueObject {

    public HumiditySensorValue(final Double value) {
        super(value);
    }

    public HumiditySensorValue() {
        super(null);
    }
}
