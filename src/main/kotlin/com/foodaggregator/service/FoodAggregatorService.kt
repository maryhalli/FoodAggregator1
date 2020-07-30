package com.foodaggregator.service

import org.json.simple.JSONArray
import org.json.simple.JSONObject

interface FoodAggregatorService {
	fun buyItem( name: String): JSONArray
	
	fun buyItemQtyPrice( name: String, quantity: Int, price: String): JSONObject
	
}