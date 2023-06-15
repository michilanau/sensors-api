package com.malanau.sensorsapi.sensor.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.malanau.sensorsapi.ApplicationTestCase;
import com.malanau.sensorsapi.sensor.domain.SensorIdMother;
import com.malanau.sensorsapi.sensor.domain.SensorNameMother;
import com.malanau.sensorsapi.sensor.domain.SensorType;
import com.malanau.sensorsapi.sensor.domain.humidity.HumiditySensorValueMother;
import com.malanau.sensorsapi.shared.domain.TimeStampMother;

import org.junit.jupiter.api.Test;

/***
 * Acceptance Test
 * */
class SensorControllerShould extends ApplicationTestCase {

    @Test
    void create_a_valid_humidity_sensor() throws Exception {
        final String method = "POST";
        final String endpoint = "/sensor";
        final String body =
                "{\n"
                        + "    \"sensor\": {\n"
                        + "        \"id\": \""
                        + SensorIdMother.random().getValue()
                        + "\",\n"
                        + "        \"name\": \""
                        + SensorNameMother.random().toString()
                        + "\",\n"
                        + "        \"timeStamp\":"
                        + TimeStampMother.random().getValue()
                        + ",\n"
                        + "        \"sensorType\": \""
                        + SensorType.Humidity
                        + "\",\n"
                        + "        \"value\":"
                        + HumiditySensorValueMother.random().getValue()
                        + "\n"
                        + "    }\n"
                        + "}";
        final Integer expectedStatusCode = 201;

        assertRequestWithBody(method, endpoint, body, expectedStatusCode);
    }
}
