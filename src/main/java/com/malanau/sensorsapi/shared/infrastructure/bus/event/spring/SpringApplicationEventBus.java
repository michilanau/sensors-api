package com.malanau.sensorsapi.shared.infrastructure.bus.event.spring;

import com.malanau.sensorsapi.shared.domain.bus.event.DomainEvent;
import com.malanau.sensorsapi.shared.domain.bus.event.EventBus;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(final ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        publisher.publishEvent(event);
    }
}
