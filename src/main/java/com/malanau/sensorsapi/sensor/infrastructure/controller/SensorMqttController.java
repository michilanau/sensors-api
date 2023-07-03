package com.malanau.sensorsapi.sensor.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malanau.sensorsapi.sensor.application.create.CreateSensorRequest;
import com.malanau.sensorsapi.sensor.application.create.SensorCreator;
import com.malanau.sensorsapi.shared.infrastructure.mqtt.MqttController;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public final class SensorMqttController extends MqttController implements MqttCallback {
    SensorCreator sensorCreator;

    public SensorMqttController(final SensorCreator sensorCreator, final Environment environment)
            throws MqttException {
        super(environment);
        this.sensorCreator = sensorCreator;
    }

    @Override
    protected IMqttClient createClient() throws MqttException {
        defaultTopic = environment.getProperty("mqtt.sensor.topic");
        return new MqttClient(
                environment.getProperty("mqtt.broker.uri"),
                environment.getProperty("mqtt.sensor.clientId"));
    }

    @Override
    public void messageArrived(final String s, final MqttMessage message) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final CreateSensorRequest createSensorRequest =
                objectMapper.readValue(message.getPayload(), CreateSensorRequest.class);

        sensorCreator.create(createSensorRequest);
    }
}
