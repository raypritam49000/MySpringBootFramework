package com.rest.api.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleCacheManager {

	private static SimpleCacheManager instance;
	private static Object monitor = new Object();
	private Map<String, Object> cache = Collections.synchronizedMap(new HashMap<String, Object>());

	private SimpleCacheManager() {
	}

	public void put(String cacheKey, Object value) {
		cache.put(cacheKey, value);
	}

	public Object get(String cacheKey) {
		return cache.get(cacheKey);
	}

	public void clear(String cacheKey) {
		cache.put(cacheKey, null);
	}

	public void clear() {
		cache.clear();
	}

	public int size() {
		return cache.size();
	}

	public boolean isEmpty() {
		return cache.isEmpty();
	}

	public boolean containsKey(Object key) {
		return cache.containsKey(key);
	}

	public static SimpleCacheManager getInstance() {
		if (instance == null) {
			synchronized (monitor) {
				if (instance == null) {
					instance = new SimpleCacheManager();
				}
			}
		}
		return instance;
	}

}