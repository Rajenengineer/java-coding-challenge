package com.mooveit.cars.enums;

import lombok.Getter;

@Getter
public enum Brands {

	FORD("FORD");
	
	private String brandName;
	
	Brands(String brandname) {
		this.brandName = brandname;
	}

}
