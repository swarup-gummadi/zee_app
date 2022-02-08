package com.learning.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "food")
public class Food {
	
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "foodId")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Setter(value = AccessLevel.NONE)
	@NotBlank
	@Size(max=50)
	private String name;
	
	@Setter(value = AccessLevel.NONE)
	@NotNull
	//@Size(max=50)
	private int cost;
	
	@Setter(value = AccessLevel.NONE)
	@NotNull
	@Enumerated(EnumType.STRING)
	private FOOD_TYPE type;
	
	@Setter(value = AccessLevel.NONE)
	@Size(max=100)
	private String description;
	
	@Setter(value = AccessLevel.NONE)
	@Size(max=100)
	private String pic;
}
