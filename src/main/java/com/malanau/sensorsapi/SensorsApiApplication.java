package com.malanau.sensorsapi;

import com.malanau.sensorsapi.shared.infrastructure.bus.event.rabbit.RabbitMqDomainEventsConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SensorsApiApplication {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext context =
                SpringApplication.run(SensorsApiApplication.class, args);

        final RabbitMqDomainEventsConsumer rabbitMqDomainEventsConsumer =
                context.getBean(RabbitMqDomainEventsConsumer.class);
        rabbitMqDomainEventsConsumer.consume();
    }
}
