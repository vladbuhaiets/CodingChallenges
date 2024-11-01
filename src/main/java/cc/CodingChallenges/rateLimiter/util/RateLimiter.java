package cc.CodingChallenges.rateLimiter.util;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.*;

@Component
@Data
public class RateLimiter {

    private ConcurrentHashMap<String, Bucket> bucketMap;

    @PostConstruct
    public void refillTokens() {
        System.out.println("Refilling tokens at : " + LocalDateTime.now().toString());
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            for (Bucket bucket : bucketMap.values()) {
                bucket.refillTokens();
            }
        }, 0L, 1L, TimeUnit.SECONDS);
    }

}
