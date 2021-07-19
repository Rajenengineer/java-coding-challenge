package com.mooveit.cars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity(name="wheel")
public class Wheels {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wheel_id")
	private Integer wheelId;
	
	private String size;
	private String type;
		
	public Wheels( String size, String type) {
		
		this.size = size;
		this.type = type;
	
	}
	
}
