package com.malanau.sensorsapi.shared.infrastructure.bus.event;

import com.malanau.sensorsapi.shared.domain.bus.event.DomainEvent;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public final class DomainEventsInformation {
    HashMap<String, Class<? extends DomainEvent>> indexedDomainEvents;

    public DomainEventsInformation() {
        final Reflections reflections = new Reflections("com.malanau");
        final Set<Class<? extends DomainEvent>> classes =
                reflections.getSubTypesOf(DomainEvent.class).stream()
                        .filter(c -> !Modifier.isAbstract(c.getModifiers()))
                        .collect(Collectors.toSet());

        try {
            indexedDomainEvents = formatEvents(classes);
        } catch (final NoSuchMethodException
                | IllegalAccessException
                | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Class<? extends DomainEvent> forName(final String name) {
        return indexedDomainEvents.get(name);
    }

    public String forClass(final Class<? extends DomainEvent> domainEventClass) {
        return indexedDomainEvents.entrySet().stream()
                .filter(
                        entry ->
                                Objects.equals(entry.getValue(), domainEventClass)
                                        || domainEventClass.isAssignableFrom(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

    private HashMap<String, Class<? extends DomainEvent>> formatEvents(
            final Set<Class<? extends DomainEvent>> domainEvents)
            throws NoSuchMethodException,
                    IllegalAccessException,
                    InvocationTargetException,
                    InstantiationException {
        final HashMap<String, Class<? extends DomainEvent>> events = new HashMap<>();

        for (final Class<? extends DomainEvent> domainEvent : domainEvents) {
            final DomainEvent nullInstance = domainEvent.getConstructor().newInstance();

            events.put(
                    (String) domainEvent.getMethod("eventName").invoke(nullInstance), domainEvent);
        }

        return events;
    }
}
