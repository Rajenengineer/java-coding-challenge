package com.mooveit.cars.execptionhandlers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandsException extends RuntimeException {

	private static final long serialVersionUID = -3435395778406715013L;
	private String message;

			
	public BrandsException(String message) {
		this.message = message;
	}

}
