package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.dto.FOOD_TYPE;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

public interface FoodService {

	public Food addFood(Food food) throws AlreadyExistsException;
	public Food updateFood(int id, Food food) throws IdNotFoundException;
	public Food getFoodById(int id) throws IdNotFoundException;
	public String deleteFoodById(int id) throws IdNotFoundException;
	public Optional<List<Food>> getAllFoodDetails();
	public Food getFoodByType(FOOD_TYPE type);
}
