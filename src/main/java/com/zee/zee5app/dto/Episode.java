package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Table(name = "episode")
public class Episode implements Comparable<Episode> {
	
//	public Episode(String id, String serId, String name, float length, String location, String trailer) {
//		super();
//		this.id = id;
//		this.serId = serId;
//		this.name = name;
//		this.length = length;
//		this.location = location;
//		this.trailer = trailer;
//	}
	
	@Id
	@Column(name = "epiId")
	private String id;
	@NotBlank
	private String name;
	@NotNull
	private float length;
	@NotBlank
	private String location;
	private String trailer;
	
	@ManyToOne
	@JoinColumn(name = "serId")
	private Series series;
	
	@Override
	public int compareTo(Episode o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

}
