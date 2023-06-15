package com.malanau.sensorsapi.sensor.infrastructure.persistence;

import com.malanau.sensorsapi.sensor.domain.Sensor;
import com.malanau.sensorsapi.sensor.domain.SensorId;
import com.malanau.sensorsapi.sensor.domain.SensorRepository;
import com.malanau.sensorsapi.shared.infrastructure.persistence.HibernateRepository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class MySqlSensorRepository extends HibernateRepository<Sensor> implements SensorRepository {

    public MySqlSensorRepository(final SessionFactory sessionFactory) {
        super(sessionFactory, Sensor.class);
    }

    @Override
    public void save(final Sensor sensor) {
        persist(sensor);
    }

    @Override
    public Optional<Sensor> search(final SensorId id) {
        return byId(id);
    }
}
