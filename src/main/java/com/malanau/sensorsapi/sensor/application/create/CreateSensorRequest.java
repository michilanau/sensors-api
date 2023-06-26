package com.malanau.sensorsapi.sensor.application.create;

import com.malanau.sensorsapi.sensor.domain.Sensor;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public final class CreateSensorRequest {
    private List<Sensor> sensors;

    public CreateSensorRequest() {}
}
