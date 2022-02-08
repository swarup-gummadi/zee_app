package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.FOOD_TYPE;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.FoodRepository;
import com.learning.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public Food addFood(Food food) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if (foodRepository.existsByName(food.getName())==true) {
			throw new AlreadyExistsException("Already existing record");
		}
		
		Food food2 = foodRepository.save(food);
		System.out.println(food2);
		if (food2!=null) {
			return food2;
		}
		else {
			return null;
		}
	}

	@Override
	public Food updateFood(int foodId, Food food) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(!this.foodRepository.existsById(foodId))
			throw new IdNotFoundException("Sorry food not found");
		
		return foodRepository.save(food);
	}
	@Override
	public Food getFoodById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = foodRepository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Food Id not found");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public String deleteFoodById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Food> optional = Optional.ofNullable(this.getFoodById(id));
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Food item not found");
			}
			else {
				foodRepository.deleteById(id);
				return "successfully deleted food item";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Food>> getAllFoodDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(foodRepository.findAll());
	}

	@Override
	public Food getFoodByType(FOOD_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Food getFoodByType(FOOD_TYPE type) {
//		// TODO Auto-generated method stub
//		Optional<Food> optional = foodRepository.fin(type);
//		if (optional.isEmpty()) {
//			throw new IdNotFoundException("Food Id not found");
//		}
//		else {
//			return optional.get();
//		}
//	}

}
