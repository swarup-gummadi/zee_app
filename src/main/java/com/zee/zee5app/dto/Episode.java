package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Episode implements Comparable<Episode> {
	

	@Id
	@NotBlank
	private String id;
//	@NotBlank
//	private String seriesId;
	@NotBlank
	private String name;
	private float length;
	private String location;
	private String trailer;
	
	@Override
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}
	
	@ManyToOne
	//episode table should have a FK seriesID. should use join column for this
	@JoinColumn(name= "seriesId")
	private Series series;

}