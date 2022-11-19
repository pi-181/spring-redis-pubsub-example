package com.example.spring_redis_pubsub_example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class RedisSubscriber {
    private final AtomicInteger counter = new AtomicInteger();

    /**
     * Bound to the "notifications" channel
     * in {@link RedisConfiguration#listenerAdapter(RedisSubscriber)}.
     *
     * @param message content of a message from Redis pub/sub channel
     */
    @SuppressWarnings("unused")
    public void receiveMessage(String message, String channel) {
        int total = counter.incrementAndGet();
        log.info("Received message from channel \"{}\" (total: {}): {}", channel, total, message);
    }
}
