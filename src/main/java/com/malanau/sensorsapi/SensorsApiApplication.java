package com.malanau.sensorsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SensorsApiApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SensorsApiApplication.class, args);
    }

}
