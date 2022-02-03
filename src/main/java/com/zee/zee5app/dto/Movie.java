package com.zee.zee5app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Movie implements Comparable<Movie>{
	

	@Setter(value = AccessLevel.NONE)
	@Id
	private String id;
	@Setter(value = AccessLevel.NONE)
	@NotBlank
	private String name;
	@NotNull
	private int ageLimit;
	@NotBlank
	private String cast;
	private String genre;
	//private float length;
	private String trailer;
	private Date releaseDate;
	private String language;
	
	
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}