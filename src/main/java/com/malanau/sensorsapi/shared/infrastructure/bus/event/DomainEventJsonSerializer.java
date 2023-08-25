package com.malanau.sensorsapi.shared.infrastructure.bus.event;

import com.malanau.sensorsapi.shared.domain.Utils;
import com.malanau.sensorsapi.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class DomainEventJsonSerializer {
    public static String serialize(final DomainEvent domainEvent) {
        final HashMap<String, Serializable> attributes = domainEvent.toPrimitives();
        attributes.put("id", domainEvent.getAggregateId());

        return Utils.jsonEncode(
                new HashMap<String, Serializable>() {
                    {
                        put(
                                "data",
                                new HashMap<String, Serializable>() {
                                    {
                                        put("id", domainEvent.getEventId());
                                        put("type", domainEvent.eventName());
                                        put("occurred_on", domainEvent.getOccurredOn());
                                        put("attributes", attributes);
                                    }
                                });
                        put("meta", new HashMap<String, Serializable>());
                    }
                });
    }
}
