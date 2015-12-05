package com.tictactoegame.elements;

import java.util.HashSet;
import java.util.Set;

import com.tictactoegame.exceptions.CellOccupiedException;
import com.tictactoegame.exceptions.InvalidInputException;

public class Board {

	private static final int SIZE = 3;
	
	private int occupiedCells = 0;

	private char[][] board = new char[SIZE][SIZE];
	
	private Set<String> validCells;

	public Board() {
		validCells = new HashSet<String>();
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				board[row][column] = ' ';
				validCells.add(row+""+column);
			}
		}
	}

	public void print() {
		int column;
		int row;
		for (row = SIZE - 1; row >= 0; row--) {
			System.out.print(row + " ");
			for (column = 0; column < SIZE; column++) {
				System.out.print("|" + board[row][column]);
			}
			System.out.println("|");
		}
		System.out.print("   ");
		for (column = 0; column < SIZE; column++) {
			System.out.print(column + " ");
		}
		System.out.println();

	}

	public void markCell(char playerMark, int row, int column) {
		if (board[row][column] != ' ') {
			throw new CellOccupiedException("Error..!!! Cell already occupied.");
		} else {
			board[row][column] = playerMark;
			occupiedCells++;
		}
	}

	public boolean hasWinner() {
		return checkRowsForWinner() || checkColumnsForWinner() || checkDiagonalsForWinner();
	}

	public boolean checkRowsForWinner() {
		for (int row = 0; row < SIZE; row++) {
			if (checkRow(row)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkColumnsForWinner() {
		for (int column = 0; column < SIZE; column++) {
			if (checkColumn(column)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonalsForWinner() {
		return checkFirstDiagonal() || checkSecondDiagonal();
	}

	private boolean checkRow(int row) {
		char cell1 = board[row][0];
		int column = 1;
		while (column < SIZE) {
			if (cell1 == ' ' || cell1 != board[row][column]) {
				return false;
			}
			column++;
		}
		return true;
	}

	private boolean checkColumn(int column) {
		char cell1 = board[0][column];
		int row = 1;
		while (row < SIZE) {
			if (cell1 == ' ' || cell1 != board[row][column]) {
				return false;
			}
			row++;
		}
		return true;
	}

	private boolean checkFirstDiagonal() {
		char cell1 = board[0][0];
		int rowColumn = 1;
		while (rowColumn < SIZE) {
			if (cell1 == ' ' || cell1 != board[rowColumn][rowColumn]) {
				return false;
			}
			rowColumn++;
		}
		return true;
	}

	private boolean checkSecondDiagonal() {
		char cell1 = board[0][2];
		int row = 1;
		int column = 1;
		while (row < SIZE) {
			if (cell1 == ' ' || cell1 != board[row][column]) {
				return false;
			}
			row++;
			column--;
		}
		return true;
	}

	public boolean isBoardFull() {
		return SIZE*SIZE == occupiedCells;
	}
	
	public void checkForValidCell(String inputCell) {
		if(validCells.contains(inputCell)){
			return;
		}else{
			throw new InvalidInputException("Error..!!! Invalid Input");
		}
	}

}
