package com.foodaggregator.controller


import org.springframework.web.bind.annotation.RestController
import org.json.simple.JSONObject
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.beans.factory.annotation.Autowired
import com.foodaggregator.service.FoodAggregatorService
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse
import org.springframework.context.annotation.ComponentScan

@RestController
@RequestMapping("/api")
class FoodAggregatorController() {
	
	@Autowired
	lateinit var foodAggregatorService : FoodAggregatorService
	
	@GetMapping("/name")
	fun buyItem(@RequestParam name:String): JSONObject = foodAggregatorService.buyItem(name)
	
	@GetMapping("/name/quantity/price")
	fun buyItemQtyPrice(@RequestParam name: String, quantity: Int, price:String): JSONObject = foodAggregatorService.buyItemQtyPrice(name,quantity,price)

}