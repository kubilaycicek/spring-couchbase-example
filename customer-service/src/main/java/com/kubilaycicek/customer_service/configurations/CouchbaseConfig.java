package com.kubilaycicek.customer_service.configurations;

import com.couchbase.client.java.Cluster;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.cache.CouchbaseCacheManager;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.kubilaycicek.customer_service.repository.CustomerRepository"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.url}")
    private String url;
    @Value("${couchbase.bucket}")
    private String bucket;
    @Value("${couchbase.username}")
    private String username;
    @Value("${couchbase.password}")
    private String password;

    @Override
    public String getConnectionString() {
        return url;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucket;
    }

    @Bean(destroyMethod = "disconnect")
    public Cluster cluster() {
        return Cluster.connect(url, username, password);
    }
    @Bean
    public CacheManager cacheManager() {
        return CouchbaseCacheManager.create(new SimpleCouchbaseClientFactory(cluster(), getBucketName(), null));
    }
}