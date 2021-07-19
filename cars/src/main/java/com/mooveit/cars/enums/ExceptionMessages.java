package com.mooveit.cars.enums;

import lombok.Getter;

@Getter
public enum ExceptionMessages {
	
	INVALID_BRAND("incorrect brand passed, not in the scope right now");
	
	private String exceptionMessage;
	
	ExceptionMessages(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
