package com.foodaggregator.serviceImpl

import com.fasterxml.jackson.core.JsonParser
import com.foodaggregator.service.FoodAggregatorService
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.client.RestTemplate
import org.json.simple.JSONObject
import org.springframework.http.HttpHeaders
import java.util.Arrays
import org.springframework.http.MediaType
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.json.simple.parser.JSONParser
import org.json.simple.JSONArray

@Service
class FoodAggregatorServiceImpl(): FoodAggregatorService {


	fun getFruits(name: String): JSONArray {
		var jsonArray = JSONArray()
		var restTemplate = RestTemplate()
		var headers = HttpHeaders()
		headers.accept = Arrays.asList(MediaType.APPLICATION_JSON);
		var entity = HttpEntity<String>(headers)
		var result = restTemplate.exchange("https://run.mocky.io/v3/c51441de-5c1a-4dc2-a44e-aab4f619926b", HttpMethod.GET, entity, String::class.java)
//		println(result.getBody())
		var result1 = result.body as String
		var parser = JSONParser()
		var jSONArray = parser.parse(result1) as JSONArray
		for (jsonOb1 in  jSONArray) {
			println(jsonOb1)
			 var jsonOb = jsonOb1 as JSONObject
			val obj = jsonOb.get("name") as String
//			println("This is value got  : "+obj)
//			println("Input getting from user : "+ name)
			if (obj.equals(name)){
				//println("inside if block : ")
				//println(jsonOb)
				jsonArray.add(jsonOb)
			}
			//return resultJson
		}
		return jsonArray;
	}

	fun getVegetables(name: String): JSONArray {
		var jsonArray = JSONArray()
		var restTemplate = RestTemplate()
		var headers = HttpHeaders()
		headers.accept = Arrays.asList(MediaType.APPLICATION_JSON);
		var entity = HttpEntity<String>(headers)
		var result = restTemplate.exchange("https://run.mocky.io/v3/4ec58fbc-e9e5-4ace-9ff0-4e893ef9663c", HttpMethod.GET, entity, String::class.java)
//		println(result.getBody())
		var result1 = result.body as String
		var parser = JSONParser()
		var jSONArray = parser.parse(result1) as JSONArray
		for (jsonOb1 in  jSONArray) {
	//		println(jsonOb1)
			var jsonOb = jsonOb1 as JSONObject
			val obj = jsonOb.get("productName") as String
//			println("This is value got  : "+obj)
//			println("Input getting from user : "+ productName)

			if (obj.equals(name)){
				//println(jsonOb)
				jsonArray.add(jsonOb)
			}
		}
		return jsonArray;
	}

	fun getGrains(name: String): JSONArray {
		var jsonArray = JSONArray()
		var restTemplate = RestTemplate()
		var headers = HttpHeaders()
		headers.accept = Arrays.asList(MediaType.APPLICATION_JSON);
		var entity = HttpEntity<String>(headers)
		var result = restTemplate.exchange("https://run.mocky.io/v3/e6c77e5c-aec9-403f-821b-e14114220148 ", HttpMethod.GET, entity, String::class.java)
		var result1 = result.body as String
		var parser = JSONParser()
		var jSONArray = parser.parse(result1) as JSONArray
		for (jsonOb1 in  jSONArray) {
			println(jsonOb1)
			var jsonOb = jsonOb1 as JSONObject
			val obj = jsonOb.get("itemName") as String

			if (obj.equals(name)){
				jsonArray.add(jsonOb)
			}
		}
		return jsonArray;
	}

	override fun buyItem(name: String): JSONArray {
		var jsonArray = JSONArray()
		name.equals("name", true)
		if (name == "apple" || name == "banana" || name == "Apple" || name == "Banana")
			jsonArray = getFruits(name)
		else if (name == "wheat" || name == "barley" || name == "rye" || name == "Wheat" || name == "Barley" || name == "Rye")
			jsonArray= getGrains(name)
		else if (name == "Carrot" || name == "Okra" || name == "Onion" || name == "carrot" || name == "okra" || name == "onion")
			jsonArray=getVegetables(name)
		else {
			var jsonobj = JSONObject()
			jsonobj.put("Description", " No result found")
			jsonArray.add(jsonobj)
		}
		return jsonArray;
	}

	fun getFruitsByQuantityPrice(name: String, quantity: Int, price: String): JSONArray {
		var jsonArray = JSONArray()
		var restTemplate = RestTemplate()
		var headers = HttpHeaders()
		headers.accept = Arrays.asList(MediaType.APPLICATION_JSON);
		var entity = HttpEntity<String>(headers)
		var result = restTemplate.exchange("https://run.mocky.io/v3/c51441de-5c1a-4dc2-a44e-aab4f619926b", HttpMethod.GET, entity, String::class.java)
		println(result.getBody())
		var result1 = result.body as String
		var parser = JSONParser()
		var jSONArray = parser.parse(result1) as JSONArray
		for (jsonOb1 in  jSONArray) {
			var jsonOb = jsonOb1 as JSONObject
			val obj1 = jsonOb.get("name") as String
			val obj2 = jsonOb.get(quantity)
			val obj3 = jsonOb.get("price") as String
			if (obj1.equals(name) && obj2==quantity && obj3.equals(price)){
				jsonArray.add(jsonOb)
			}
		}
		return jsonArray;
	}

	fun getVegetablesByQuantityPrice(name: String, quantity: Int, price: String): JSONArray {
		var jsonArray = JSONArray()
		var restTemplate = RestTemplate()
		var headers = HttpHeaders()
		headers.accept = Arrays.asList(MediaType.APPLICATION_JSON);
		var entity = HttpEntity<String>(headers)
		var result = restTemplate.exchange("https://run.mocky.io/v3/4ec58fbc-e9e5-4ace-9ff0-4e893ef9663c", HttpMethod.GET, entity, String::class.java)
		println(result.getBody())
		var result1 = result.body as String
		var parser = JSONParser()
		var jSONArray = parser.parse(result1) as JSONArray
		for (jsonOb1 in  jSONArray) {
			println(jsonOb1)
			var jsonOb = jsonOb1 as JSONObject
			val obj1 = jsonOb.get("productName") as String
			val obj2 = jsonOb.get(quantity)
			val obj3 = jsonOb.get("price") as String
			if (obj1.equals(name) && obj2==quantity && obj3.equals(price)){
				jsonArray.add(jsonOb)
			}
		}
		return jsonArray;
	}


	fun getGrainsByQuantityPrice(name: String, quantity: Int, price: String): JSONArray {
		var jsonArray = JSONArray()
		var restTemplate = RestTemplate()
		var headers = HttpHeaders()
		headers.accept = Arrays.asList(MediaType.APPLICATION_JSON);
		var entity = HttpEntity<String>(headers)
		var result = restTemplate.exchange(" https://run.mocky.io/v3/e6c77e5c-aec9-403f-821b-e14114220148  ", HttpMethod.GET, entity, String::class.java)
		println(result.getBody())
		var result1 = result.body as String
		var parser = JSONParser()
		var jSONArray = parser.parse(result1) as JSONArray
		for (jsonOb1 in  jSONArray) {
			println(jsonOb1)
			var jsonOb = jsonOb1 as JSONObject
			val obj1 = jsonOb.get("itemName") as String
			val obj2 = jsonOb.get(quantity)
			val obj3 = jsonOb.get("price") as String
			if (obj1.equals(name) && obj2==quantity && obj3.equals(price)){
				jsonArray.add(jsonOb)
			}
		}
		return jsonArray;
	}

	override fun buyItemQtyPrice(name: String, quantity: Int, price: String): JSONArray {
		var jsonArray = JSONArray()
		if (name == "apple" || name == "banana"  || name == "Apple" || name == "Banana")
			jsonArray=getFruitsByQuantityPrice(name, quantity, price)
		else if (name == "wheat" || name == "barley" || name == "rye" || name == "Wheat" || name == "Barley" || name == "Rye")
			jsonArray=getGrainsByQuantityPrice(name, quantity, price)
		else if (name == "Carrot" || name == "Okra" || name == "Onion" || name == "carrot" || name == "okra" || name == "onion")
			jsonArray=getGrainsByQuantityPrice(name, quantity, price)
		else {
			var jsonobj = JSONObject()
			jsonobj.put("Description", " No result found")
			jsonArray.add(jsonobj)
		}
		return jsonArray;
	}
}
