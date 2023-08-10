package com.malanau.sensorsapi.sensor_counter.infrastructure.persistence;

import com.malanau.sensorsapi.sensor_counter.domain.SensorCounter;
import com.malanau.sensorsapi.sensor_counter.domain.SensorCounterRepository;
import com.malanau.sensorsapi.shared.infrastructure.persistence.HibernateRepository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MySqlSensorCounterRepository extends HibernateRepository<SensorCounter>
        implements SensorCounterRepository {
    public MySqlSensorCounterRepository(final SessionFactory sessionFactory) {
        super(sessionFactory, SensorCounter.class);
    }

    @Override
    public void save(final SensorCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<SensorCounter> search() {
        final List<SensorCounter> sensorCounter = all();

        return 0 == sensorCounter.size()
                ? Optional.empty()
                : Optional.ofNullable(sensorCounter.get(0));
    }
}
