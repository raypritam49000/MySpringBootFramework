package com.rest.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class AppConfig {

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		List<Cache> cacheList = new ArrayList<Cache>();
		cacheList.add(new ConcurrentMapCache("employeeCache"));
		cacheList.add(new ConcurrentMapCache("studentCache"));
		simpleCacheManager.setCaches(cacheList);
		return simpleCacheManager;
	}

}
