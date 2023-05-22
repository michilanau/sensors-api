package com.malanau.sensorsapi.sensor.infrastructure;

import com.malanau.sensorsapi.ContextInfrastructureTestCase;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class SensorModuleInfrastructureTestCase extends ContextInfrastructureTestCase {
    @Autowired protected SensorRepository sensorRepository;
}
