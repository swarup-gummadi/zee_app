package com.learning.dto;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class FoodType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodTypeId;
	
	@Enumerated(EnumType.STRING)
	private EFOODTYPE foodType;

}