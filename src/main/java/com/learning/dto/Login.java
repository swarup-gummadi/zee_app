package com.learning.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "login")
public class Login {
	
	@Setter(value = AccessLevel.NONE)
	@NotBlank
	@Id
	private String email;
	
	@Setter(value = AccessLevel.NONE)
	@NotBlank
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "regId")
    @JsonProperty(access = Access.WRITE_ONLY)
	private Register register;
}
