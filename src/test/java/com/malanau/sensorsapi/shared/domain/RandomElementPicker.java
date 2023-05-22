package com.malanau.sensorsapi.shared.domain;

import java.util.Random;

public final class RandomElementPicker {
    @SafeVarargs
    public static <T> T from(final T... elements) {
        final Random rand = new Random();

        return elements[rand.nextInt(elements.length)];
    }
}
