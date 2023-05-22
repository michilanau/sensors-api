package com.malanau.sensorsapi.sensor.application.create;

import com.malanau.sensorsapi.sensor.domain.Sensor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CreateSensorRequest {
    private Sensor sensor;

    public CreateSensorRequest() {}
}
