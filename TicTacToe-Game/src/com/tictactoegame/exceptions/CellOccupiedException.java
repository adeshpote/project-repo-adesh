package com.tictactoegame.exceptions;

public class CellOccupiedException extends InvalidInputException {

	private static final long serialVersionUID = 1L;

	public CellOccupiedException(String message) {
		super(message);
	}
}
