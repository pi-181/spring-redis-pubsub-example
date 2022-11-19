package com.example.spring_redis_pubsub_example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
@Slf4j
public class RedisPublisher {
    private final StringRedisTemplate template;
    private final AtomicInteger counter = new AtomicInteger();

    /**
     * Sends message to the "notifications" channel every second.
     */
    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        int totalSent = counter.incrementAndGet();
        template.convertAndSend("notifications", "Hello to Redis subs! (№ " + totalSent + ")");
        log.info("Message published (total: {})", totalSent);
    }
}
