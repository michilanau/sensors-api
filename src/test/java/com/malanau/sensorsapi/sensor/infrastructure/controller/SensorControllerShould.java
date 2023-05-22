package com.malanau.sensorsapi.sensor.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.malanau.sensorsapi.ApplicationTestCase;

import org.junit.jupiter.api.Test;

class SensorControllerShould extends ApplicationTestCase {

    @Test
    void create() throws Exception {
        final String method = "POST";
        /*
        final String courseId = CourseIdMother.random().value();
        final String courseName = CourseNameMother.random().toString();
        final String courseDuration = CourseDurationMother.random().toString();
        */
        final String endpoint = "/sensor";
        final String body =
                "{\n"
                        + "    \"sensor\": {\n"
                        + "        \"id\": \"04778c84-f5a2-11ed-b67e-0242ac120002\",\n"
                        + "        \"name\": \"sensor de humedad\",\n"
                        + "        \"timeStamp\": 123456,\n"
                        + "        \"sensorType\": \"Humidity\",\n"
                        + "        \"value\": 12.00\n"
                        + "    }\n"
                        + "}";
        final Integer expectedStatusCode = 201;

        assertRequestWithBody(method, endpoint, body, expectedStatusCode);
    }
}
