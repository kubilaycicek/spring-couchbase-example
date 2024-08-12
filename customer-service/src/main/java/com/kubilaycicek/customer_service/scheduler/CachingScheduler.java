package com.kubilaycicek.customer_service.scheduler;


import com.kubilaycicek.customer_service.service.CacheService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CachingScheduler {

    private final CacheService cacheService;

    public CachingScheduler(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Scheduled(cron = "@hourly")
    public void evictAllCaches() {
        cacheService.evictAllCaches();
    }
}
