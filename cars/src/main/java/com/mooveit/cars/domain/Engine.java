package com.mooveit.cars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@Entity(name="engine")
public class Engine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "engine_id")
	private Integer engineId;
	
	@NonNull
	private Integer power;
	
	
	@NonNull
	private String type;
	

	
	public Engine(Integer power, String type) {
		this.type = type;
		this.power = power;
	}

}

