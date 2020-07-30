package com.foodaggregator.dao

import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AllItemsDao {

    @Autowired
    lateinit var  cache : CacheHelper

    fun findAllItemsByName(name : String): JSONArray {
        var result  = JSONArray()
        if (cache.getMapDetailsCacheObj().containsKey(name)) {
            return cache.getMapDetailsCacheObj().get(name);
        }
        return result
    }

    fun findAllItemsByNameQuantityPrice(name : String,quantity: Int, price: String): JSONArray {
        var result  = JSONArray()
        if (cache.getMapDetailsCacheObj().containsKey(name)) {
            return cache.getMapDetailsCacheObj().get(name);
        }
        if (cache.getMapDetailsCacheObj().containsKey(quantity.toString())) {
            return cache.getMapDetailsCacheObj().get(quantity.toString());
        }
        if (cache.getMapDetailsCacheObj().containsKey(price)) {
            return cache.getMapDetailsCacheObj().get(price);
        }
        return result
    }

}