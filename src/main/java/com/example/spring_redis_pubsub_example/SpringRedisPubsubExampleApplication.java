package com.example.spring_redis_pubsub_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringRedisPubsubExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisPubsubExampleApplication.class, args);
    }

}
