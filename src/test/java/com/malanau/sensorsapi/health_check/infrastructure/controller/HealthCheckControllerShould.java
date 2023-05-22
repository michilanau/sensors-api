package com.malanau.sensorsapi.health_check.infrastructure.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.malanau.sensorsapi.ApplicationTestCase;

import org.junit.jupiter.api.Test;

/***
 * Acceptance Test
 * */
final class HealthCheckControllerShould extends ApplicationTestCase {

    @Test
    void health_check() throws Exception {
        final String endpoint = "/health-check";
        final String expectedResponse = "{\"application\":\"sensors-api\",\"status\":\"ok\"}";
        final Integer expectedStatusCode = 200;

        assertResponse(endpoint, expectedStatusCode, expectedResponse);
    }
}
