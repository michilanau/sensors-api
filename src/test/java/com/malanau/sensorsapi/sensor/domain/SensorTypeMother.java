package com.malanau.sensorsapi.sensor.domain;

import com.malanau.sensorsapi.shared.domain.RandomElementPicker;

public class SensorTypeMother {
    
    public static SensorType create(final String value){
        return SensorType.valueOf(value);
    }

    public static SensorType random() {

        return RandomElementPicker.from(SensorType.values());
    }
}
