package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	boolean existsByName(String name);

}
