package com.malanau.sensorsapi.sensor.domain.humidity;

import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.sensor.domain.SensorIdMother;
import com.malanau.sensorsapi.sensor.domain.SensorName;
import com.malanau.sensorsapi.sensor.domain.SensorNameMother;
import com.malanau.sensorsapi.shared.domain.TimeStamp;
import com.malanau.sensorsapi.shared.domain.TimeStampMother;

public class HumiditySensorMother {
    public static HumiditySensor create(
            final SensorId sensorId,
            final SensorName sensorName,
            final TimeStamp timeStamp,
            final HumiditySensorValue value) {
        return new HumiditySensor(sensorId, sensorName, timeStamp, value);
    }

    public static HumiditySensor random() {
        return create(
                SensorIdMother.random(),
                SensorNameMother.random(),
                TimeStampMother.random(),
                HumiditySensorValueMother.random());
    }
}
