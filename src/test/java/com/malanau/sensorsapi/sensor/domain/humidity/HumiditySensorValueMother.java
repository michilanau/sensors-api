package com.malanau.sensorsapi.sensor.domain.humidity;

import com.malanau.sensorsapi.shared.domain.DoubleMother;

public class HumiditySensorValueMother {

    public static HumiditySensorValue create(final Double value) {
        return new HumiditySensorValue(value);
    }

    public static HumiditySensorValue random() {
        return create(DoubleMother.random());
    }
}
