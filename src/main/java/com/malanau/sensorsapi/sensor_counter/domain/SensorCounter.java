package com.malanau.sensorsapi.sensor_counter.domain;

import com.malanau.sensorsapi.sensor.domain.SensorId;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public final class SensorCounter {
    private SensorCounterId id;
    private SensorCounterTotal total;

    public static SensorCounter initialize(final String id) {
        return new SensorCounter(new SensorCounterId(id), SensorCounterTotal.initialize());
    }

    public SensorCounter() {
        id = null;
        total = null;
    }

    public void increment(final SensorId id) {
        total = total.increment();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final SensorCounter that)) {
            return false;
        }
        return Objects.equals(id, that.id) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total);
    }
}
