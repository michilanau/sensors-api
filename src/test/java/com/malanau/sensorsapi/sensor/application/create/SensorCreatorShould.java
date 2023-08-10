package com.malanau.sensorsapi.sensor.application.create;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;
import com.malanau.sensorsapi.sensor.domain.humidity.HumiditySensorMother;
import com.malanau.sensorsapi.shared.domain.bus.event.EventBus;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/***
 * Unit Test
 * */
class SensorCreatorShould {
    @Test
    void save_valid_sensors() {
        final SensorRepository repository = mock(SensorRepository.class);
        final EventBus eventBus = mock(EventBus.class);
        final SensorCreator creator = new SensorCreator(repository, eventBus);

        final List<Sensor> sensors = (List<Sensor>) sensors();

        final CreateSensorRequest request = new CreateSensorRequest(sensors);

        creator.create(request);

        for (final Sensor sensor : sensors) {
            verify(repository, atLeastOnce()).save(sensor);
        }
    }

    // We can add to the list all the sub Sensor types we want to test
    private List<? extends Sensor> sensors() {
        return Arrays.asList(HumiditySensorMother.random());
    }
}
