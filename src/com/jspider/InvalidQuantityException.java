package com.jspider;

public class InvalidQuantityException extends RuntimeException {
	private String message;

	public InvalidQuantityException(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
