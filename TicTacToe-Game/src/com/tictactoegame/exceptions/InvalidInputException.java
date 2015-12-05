package com.tictactoegame.exceptions;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorMessage;
	
	public InvalidInputException(String message) {
		errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
