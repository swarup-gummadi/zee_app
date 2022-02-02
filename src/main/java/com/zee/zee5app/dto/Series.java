package com.zee.zee5app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class Series implements Comparable<Series> {
	
	

	@Setter(value = AccessLevel.NONE)
	@Id
	private String id;
	@NotBlank
	
	@Setter(value = AccessLevel.NONE)
	private String name;
	@NotNull
	@Max(value = 70)
	private int ageLimit;
	private String trailer;
	@NotBlank
	private String cast;
	@NotBlank
	private GENRE genre;
	//private float length;
	@NotNull
	private Date releaseDate;
	@NotBlank
	private String language;
	@Min(value = 1)
	private int noOfEpisodes;
	
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

}