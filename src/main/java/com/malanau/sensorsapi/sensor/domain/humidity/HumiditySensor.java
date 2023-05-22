package com.malanau.sensorsapi.sensor.domain.humidity;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.sensor.domain.SensorName;
import com.malanau.sensorsapi.sensor.domain.SensorType;
import com.malanau.sensorsapi.shared.domain.TimeStamp;

import lombok.Getter;

@Getter
public final class HumiditySensor extends Sensor {

    private final HumiditySensorValue value;

    public HumiditySensor(
            final SensorId id,
            final SensorName name,
            final TimeStamp timeStamp,
            final HumiditySensorValue value) {
        super(id, name, timeStamp, SensorType.Humidity);
        this.value = value;
    }
}
