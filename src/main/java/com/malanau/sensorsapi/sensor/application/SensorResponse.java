package com.malanau.sensorsapi.sensor.application;

import com.malanau.sensorsapi.sensor.domain.Sensor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SensorResponse {

    private Sensor sensor;

    public static SensorResponse fromAggregate(final Sensor sensor) {
        return new SensorResponse(sensor);
    }
}
