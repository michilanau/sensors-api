package com.malanau.sensorsapi.shared.infrastructure.bus.event;

import com.malanau.sensorsapi.shared.domain.Utils;
import com.malanau.sensorsapi.shared.domain.bus.event.DomainEvent;

import java.util.List;

public final class DomainEventSubscriberInformation {
    private final Class<?> subscriberClass;
    private final List<Class<? extends DomainEvent>> subscribedEvents;

    public DomainEventSubscriberInformation(
            final Class<?> subscriberClass,
            final List<Class<? extends DomainEvent>> subscribedEvents) {
        this.subscriberClass = subscriberClass;
        this.subscribedEvents = subscribedEvents;
    }

    public Class<?> subscriberClass() {
        return subscriberClass;
    }

    public String contextName() {
        final String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[2];
    }

    public String moduleName() {
        final String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[3];
    }

    public String className() {
        final String[] nameParts = subscriberClass.getName().split("\\.");

        return nameParts[nameParts.length - 1];
    }

    public List<Class<? extends DomainEvent>> subscribedEvents() {
        return subscribedEvents;
    }

    public String formatRabbitMqQueueName() {
        return String.format(
                "malanau.%s.%s.%s", contextName(), moduleName(), Utils.toSnake(className()));
    }
}
