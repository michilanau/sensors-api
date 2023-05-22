package com.malanau.sensorsapi.sensor.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.malanau.sensorsapi.sensor.domain.humidity.HumiditySensor;
import com.malanau.sensorsapi.shared.domain.TimeStamp;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "sensorType",
        use = JsonTypeInfo.Id.NAME,
        visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = HumiditySensor.class, name = "Humidity")})
@Getter
@AllArgsConstructor
public abstract class Sensor {
    private final SensorId id;
    private final SensorName name;
    private final TimeStamp timeStamp;
    private final SensorType sensorType;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sensor sensor)) {
            return false;
        }
        return Objects.equals(id, sensor.id)
                && Objects.equals(name, sensor.name)
                && Objects.equals(timeStamp, sensor.timeStamp)
                && sensorType == sensor.sensorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, timeStamp, sensorType);
    }
}
