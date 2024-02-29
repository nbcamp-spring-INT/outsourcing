package com.icomfortableworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@PropertySource(value = {"classpath:db.properties", "classpath:jwt.properties"})
public class IComfortableWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(IComfortableWorldApplication.class, args);
    }

}
