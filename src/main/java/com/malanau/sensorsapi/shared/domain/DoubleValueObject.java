package com.malanau.sensorsapi.shared.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class DoubleValueObject {
    private final Double value;

    public DoubleValueObject(final Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DoubleValueObject that)) {
            return false;
        }
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
