package com.malanau.sensorsapi.shared.infrastructure.bus.event.rabbit;

import com.malanau.sensorsapi.shared.domain.bus.event.DomainEvent;
import com.malanau.sensorsapi.shared.infrastructure.bus.event.DomainEventJsonSerializer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public final class RabbitMqPublisher {
    private final RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(final DomainEvent domainEvent, final String exchangeName)
            throws AmqpException {
        final String serializedDomainEvent = DomainEventJsonSerializer.serialize(domainEvent);

        final Message message =
                new Message(
                        serializedDomainEvent.getBytes(),
                        MessagePropertiesBuilder.newInstance()
                                .setContentEncoding("utf-8")
                                .setContentType("application/json")
                                .build());

        rabbitTemplate.send(exchangeName, domainEvent.eventName(), message);
    }

    public void publish(
            final Message domainEvent, final String exchangeName, final String routingKey)
            throws AmqpException {
        rabbitTemplate.send(exchangeName, routingKey, domainEvent);
    }
}
