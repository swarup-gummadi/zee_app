package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.learning.dto.EFOODTYPE;
import com.learning.dto.Food;
//import com.learning.dto.FoodType;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.FoodService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	

	@PostMapping("/addFood")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addFood(@RequestBody Food food) throws AlreadyExistsException {
		Food result = foodService.addFood(food);
		return ResponseEntity.status(201).body(result);
	}
	

	@GetMapping("/{foodId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> getFoodById(@PathVariable("foodId") Long foodId) throws IdNotFoundException {
		Food result = foodService.getFoodById(foodId);
		return ResponseEntity.ok(result);
	}
	

	@PutMapping("/{foodId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateFood(@RequestBody @PathVariable("foodId") Long foodId,  Food food) throws IdNotFoundException {
		Food result = foodService.updateFood(foodId, food);
		return ResponseEntity.status(200).body(result);
	}
	

	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> getAllFood() {
		Optional<List<Food>> optional = foodService.getAllFoodDetails();
		if (optional.isEmpty()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "No record found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());
	}
	

	@DeleteMapping("/{foodId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteFoodById(@PathVariable("foodId") Long foodId) throws IdNotFoundException {
		foodService.deleteFoodById(foodId);
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Food item deleted");
		return ResponseEntity.status(200).body(map);
	}

}