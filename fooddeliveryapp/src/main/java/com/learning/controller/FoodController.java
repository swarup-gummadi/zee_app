package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@PostMapping("")
	public ResponseEntity<?> addFood(@Valid @RequestBody Food food) throws AlreadyExistsException{
		Food result = foodService.addFood(food);
		System.out.println(result);
		return ResponseEntity.status(201).body(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFoodById(@PathVariable("id") int id) throws IdNotFoundException{
		Food result = foodService.getFoodById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllFoodDetails(){
		Optional<List<Food>> optional = foodService.getAllFoodDetails();
		if (optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			map.put("message","no record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteFoodById(@PathVariable("id") int id) throws IdNotFoundException{
		String result = foodService.deleteFoodById(id);
		if( result.equals("successfully deleted food item")) {
			Map<String, String> map = new HashMap<>();
			map.put("message","Food item deleted successfully");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		else {
			Map<String, String> map = new HashMap<>();
			map.put("message","Sorry no food item with ID found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
	}

	@PutMapping("/update/{foodId}")
	public ResponseEntity<?> updateFood(@PathVariable("foodId") int foodId, @RequestBody Food food) throws IdNotFoundException
	{
		Food result = foodService.updateFood(foodId, food);
		return ResponseEntity.status(201).body(result);
	}
}
