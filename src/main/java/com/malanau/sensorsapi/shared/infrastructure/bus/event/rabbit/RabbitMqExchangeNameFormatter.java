package com.malanau.sensorsapi.shared.infrastructure.bus.event.rabbit;

public final class RabbitMqExchangeNameFormatter {
    public static String retry(final String exchangeName) {
        return String.format("retry-%s", exchangeName);
    }

    public static String deadLetter(final String exchangeName) {
        return String.format("dead_letter-%s", exchangeName);
    }
}

