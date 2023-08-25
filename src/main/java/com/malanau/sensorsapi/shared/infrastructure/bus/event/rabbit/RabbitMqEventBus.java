package com.malanau.sensorsapi.shared.infrastructure.bus.event.rabbit;

import com.malanau.sensorsapi.shared.domain.bus.event.DomainEvent;
import com.malanau.sensorsapi.shared.domain.bus.event.EventBus;

import org.springframework.amqp.AmqpException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RabbitMqEventBus implements EventBus {
    private final RabbitMqPublisher publisher;
    private final String exchangeName;

    public RabbitMqEventBus(final RabbitMqPublisher publisher) {
        this.publisher = publisher;
        exchangeName = "domain_events";
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent domainEvent) {
        try {
            publisher.publish(domainEvent, exchangeName);
        } catch (final AmqpException error) {
            System.err.println("RabbitMqEventBus> Error publishing event: " + domainEvent);
        }
    }
}
