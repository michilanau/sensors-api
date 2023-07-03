package com.malanau.sensorsapi.shared.infrastructure.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.core.env.Environment;

public abstract class MqttController implements MqttCallback {
    protected final IMqttClient client;
    protected final MqttConnectOptions options;
    protected String defaultTopic;
    protected Environment environment;

    public MqttController(final Environment environment) throws MqttException {
        this.environment = environment;

        client = createClient();
        client.setCallback(this);

        options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setAutomaticReconnect(true);
    }

    protected abstract IMqttClient createClient() throws MqttException;

    private void connect() throws MqttException {
        if (!client.isConnected()) {
            client.connect(options);
        }
    }

    public void disconnect() throws MqttException {
        if (client.isConnected()) {
            client.disconnect();
        }
    }

    public void subscribe(final String topic) throws MqttException {
        connect();
        client.subscribe(topic == null ? defaultTopic : topic);
    }

    @Override
    public void connectionLost(final Throwable throwable) {
        System.err.println("Connection to MQTT broker was lost");
        System.err.println("Cause -->" + throwable.getCause().getMessage());
    }

    @Override
    public void deliveryComplete(final IMqttDeliveryToken iMqttDeliveryToken) {}
}
