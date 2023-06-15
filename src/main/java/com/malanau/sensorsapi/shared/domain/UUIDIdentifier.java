package com.malanau.sensorsapi.shared.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
public abstract class UUIDIdentifier implements Serializable {
    protected final String value;

    public UUIDIdentifier(final String value) {
        ensureValidUuid(value);

        this.value = value;
    }

    private void ensureValidUuid(final String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UUIDIdentifier that)) {
            return false;
        }
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
