package com.malanau.sensorsapi.shared.domain;

public class TimeStampMother {
    public static TimeStamp create(final Long value) {
        return new TimeStamp(value);
    }

    public static TimeStamp random() {
        return create(MotherCreator.random().date().birthday().getTime());
    }
}
