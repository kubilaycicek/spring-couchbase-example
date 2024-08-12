package com.kubilaycicek.customer_service.service.impl;

import com.kubilaycicek.customer_service.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {
    private final CacheManager cacheManager;

    public void evictSingleCacheValue(String cacheName, String cacheKey) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).evict(cacheKey);
        log.info("Deleted  name {} key {}", cacheName, cacheKey);
    }

    public void evictAllCacheValues(String cacheName) {
        cacheManager.getCache(cacheName).clear();
        log.info("Deleted  name {} ", cacheName);
    }

    public void evictAllCaches() {
        cacheManager.getCacheNames().stream().forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
        log.info("Deleted  All Caches");
    }
}
