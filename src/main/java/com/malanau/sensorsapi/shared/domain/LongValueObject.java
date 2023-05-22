package com.malanau.sensorsapi.shared.domain;

import java.util.Objects;

public abstract class LongValueObject {
    private final Long value;
    
    public LongValueObject(final Long value){
        this.value = value;
    }
    
    public Long value(){
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LongValueObject that)) {
            return false;
        }
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
