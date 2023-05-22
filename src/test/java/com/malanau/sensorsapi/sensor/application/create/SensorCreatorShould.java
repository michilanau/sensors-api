package com.malanau.sensorsapi.sensor.application.create;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;
import com.malanau.sensorsapi.sensor.domain.humidity.HumiditySensorMother;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/***
 * Unit Test
 * */
class SensorCreatorShould {
    @Test
    void save_a_valid_sensor() {
        final SensorRepository repository = mock(SensorRepository.class);
        final SensorCreator creator = new SensorCreator(repository);

        for (final Sensor sensor : sensors()) {
            final CreateSensorRequest request = new CreateSensorRequest(sensor);

            creator.create(request);

            verify(repository, atLeastOnce()).save(sensor);
        }
    }

    // We can add to the list all the sub Sensor types we want to test
    private List<? extends Sensor> sensors() {
        return Arrays.asList(HumiditySensorMother.random());
    }
}
