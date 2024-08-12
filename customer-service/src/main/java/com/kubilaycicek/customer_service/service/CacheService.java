package com.kubilaycicek.customer_service.service;

import org.springframework.cache.CacheManager;

public interface CacheService {
     void evictSingleCacheValue(String cacheName, String cacheKey);
     void evictAllCacheValues(String cacheName);
     void evictAllCaches();
}
