package com.malanau.sensorsapi.shared.infrastructure.bus.event;

import com.malanau.sensorsapi.shared.domain.bus.event.DomainEventSubscriber;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

@Service
public final class DomainEventSubscribersInformation {
    HashMap<Class<?>, DomainEventSubscriberInformation> information;

    public DomainEventSubscribersInformation(
            final HashMap<Class<?>, DomainEventSubscriberInformation> information) {
        this.information = information;
    }

    public DomainEventSubscribersInformation() {
        this(scanDomainEventSubscribers());
    }

    private static HashMap<Class<?>, DomainEventSubscriberInformation>
            scanDomainEventSubscribers() {
        final Reflections reflections = new Reflections("com.malanau");
        final Set<Class<?>> subscribers =
                reflections.getTypesAnnotatedWith(DomainEventSubscriber.class);

        final HashMap<Class<?>, DomainEventSubscriberInformation> subscribersInformation =
                new HashMap<>();

        for (final Class<?> subscriberClass : subscribers) {
            final DomainEventSubscriber annotation =
                    subscriberClass.getAnnotation(DomainEventSubscriber.class);

            subscribersInformation.put(
                    subscriberClass,
                    new DomainEventSubscriberInformation(
                            subscriberClass, Arrays.asList(annotation.value())));
        }

        return subscribersInformation;
    }

    public Collection<DomainEventSubscriberInformation> all() {
        return information.values();
    }

    public String[] rabbitMqFormattedNames() {
        return information.values().stream()
                .map(DomainEventSubscriberInformation::formatRabbitMqQueueName)
                .distinct()
                .toArray(String[]::new);
    }
}
