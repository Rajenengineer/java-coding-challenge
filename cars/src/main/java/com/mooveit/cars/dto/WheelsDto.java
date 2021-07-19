package com.mooveit.cars.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import lombok.Data;

@Data
@XStreamAlias("WHEELS")
public class WheelsDto {

	@XStreamOmitField
	private Integer id;
	@XStreamAsAttribute
	private String size;
	@XStreamAsAttribute
	private String type;

	public WheelsDto() {
	}

	public WheelsDto(String size, String type) {
		this.size = size;
		this.type = type;
	}

	@Override
	public String toString() {
		return "WheelsDto{" + "id=" + id + ", size='" + size + '\'' + ", type='" + type + '\'' + '}';
	}
}
