package com.foodaggregator.dao

import org.ehcache.Cache
import org.ehcache.CacheManager
import org.ehcache.config.builders.CacheConfigurationBuilder
import org.ehcache.config.builders.CacheManagerBuilder
import org.ehcache.config.builders.ExpiryPolicyBuilder
import org.ehcache.config.builders.ResourcePoolsBuilder
import org.json.simple.JSONArray
import org.springframework.stereotype.Component
import java.time.Duration


@Component
class CacheHelper {
    var cacheManager: CacheManager = CacheManagerBuilder.newCacheManagerBuilder().build()

    lateinit var mapDetailsCache : Cache<String, JSONArray>
    init {
        cacheManager.init();
        mapDetailsCache = cacheManager
                .createCache("MapCache", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(String::class.java,
                                JSONArray::class.java, ResourcePoolsBuilder.heap(100))
                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(60*60*24))).build())
    }

    fun getMapDetailsCacheObj(): Cache<String, JSONArray>{
        return mapDetailsCache
    }
}