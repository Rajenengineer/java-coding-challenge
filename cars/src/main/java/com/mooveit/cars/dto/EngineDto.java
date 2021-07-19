package com.mooveit.cars.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XStreamAlias("ENGINE")
@NoArgsConstructor
public class EngineDto {

	@XStreamOmitField
	private Integer id;
	@XStreamAsAttribute
	private Integer power;
	@XStreamAsAttribute
	private String type;


	public EngineDto(Integer power, String type) {
		this.power = power;
		this.type = type;
	}

	@Override
	public String toString() {
		return "EngineDto{" + "id=" + id + ", power='" + power + '\'' + ", type='" + type + '\'' + '}';
	}
}
