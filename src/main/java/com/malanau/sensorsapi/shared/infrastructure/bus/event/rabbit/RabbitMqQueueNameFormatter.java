package com.malanau.sensorsapi.shared.infrastructure.bus.event.rabbit;

import com.malanau.sensorsapi.shared.infrastructure.bus.event.DomainEventSubscriberInformation;

public final class RabbitMqQueueNameFormatter {
    public static String format(final DomainEventSubscriberInformation information) {
        return information.formatRabbitMqQueueName();
    }

    public static String formatRetry(final DomainEventSubscriberInformation information) {
        return String.format("retry.%s", format(information));
    }

    public static String formatDeadLetter(final DomainEventSubscriberInformation information) {
        return String.format("dead_letter.%s", format(information));
    }
}
