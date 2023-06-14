package com.malanau.sensorsapi.sensor.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.*;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorIdMother;
import com.malanau.sensorsapi.sensor.domain.humidity.HumiditySensorMother;
import com.malanau.sensorsapi.sensor.infrastructure.SensorModuleInfrastructureTestCase;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/***
 * Integration Test
 * */
@Transactional
class MySqlSensorRepositoryShould extends SensorModuleInfrastructureTestCase {

    @Test
    void save_a_valid_sensor() {
        for (final Sensor sensor : sensors()) {
            sensorRepository.save(sensor);
        }
    }

    @Test
    void search_an_existing_sensor() {
        for (final Sensor sensor : sensors()) {
            sensorRepository.save(sensor);

            assertEquals(Optional.of(sensor), sensorRepository.search(sensor.getId()));
        }
    }

    @Test
    void not_find_a_non_existing_sensor() {
        assertFalse(sensorRepository.search(SensorIdMother.random()).isPresent());
    }

    // We can add to the list all the sub Sensor types we want to test
    private List<? extends Sensor> sensors() {
        return Arrays.asList((HumiditySensorMother.random()));
    }
}
