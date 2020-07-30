package com.foodaggregator.service

import org.json.simple.JSONObject

interface FoodAggregatorService {
	fun buyItem( name: String): JSONObject
	
	fun buyItemQtyPrice( name: String, quantity: Int, price: String): JSONObject
	
}