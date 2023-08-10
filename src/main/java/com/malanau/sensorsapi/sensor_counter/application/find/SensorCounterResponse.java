package com.malanau.sensorsapi.sensor_counter.application.find;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public final class SensorCounterResponse {
    private Integer total;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final SensorCounterResponse that)) {
            return false;
        }
        return Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
