package com.tictactoegame.runner;

import java.io.IOException;

import com.tictactoegame.common.InputReader;
import com.tictactoegame.elements.Board;
import com.tictactoegame.elements.Player;
import com.tictactoegame.exceptions.CellOccupiedException;
import com.tictactoegame.exceptions.InvalidInputException;

public class GameRunner {
	private Board board;
	private Player player1;
	private Player player2;
	private InputReader inputReader;

	public GameRunner() {
		inputReader = new InputReader();
		player1 = new Player(inputReader.getUserInput("Enter Player Name 1"), 'O');
		player2 = new Player(inputReader.getUserInput("Enter Player Name 2"), 'X');
		board = new Board();
	}

	public void play() {
		String playerInput = null;
		int turnCount = 1;
		String winnerOrDraw = "Game Drawn..!!";
		boolean keepPlaying = true;
		Player currentPlayer;
		while (keepPlaying) {
			currentPlayer = turnCount % 2 == 1 ? player1 : player2;
			while (playerInput == null) {
				board.print();
				playerInput = readAndValidateUserInput(currentPlayer.getName(),
						currentPlayer.getMark());
			}
			if (board.hasWinner()) {
				winnerOrDraw = currentPlayer.getName() + " wins..!!";
				keepPlaying = false;
			} else if (board.isBoardFull()) {
				keepPlaying = false;
			}
			playerInput = null;
			turnCount++;
		}
		printResult(winnerOrDraw);

	}

	private String readAndValidateUserInput(String userName, char userMark) {
		String playerInput = null;
		try {
			playerInput = inputReader.getUserInput(userName
					+ " turn. Enter <row><col>. Eg. 20 for top left cell.");
			board.checkForValidCell(playerInput);
			markBoardCell(userMark, playerInput);
		} catch (CellOccupiedException wrongCell) {
			System.out.println(wrongCell.getErrorMessage());
			playerInput = null;
		} catch (InvalidInputException invalidInput) {
			System.out.println(invalidInput.getErrorMessage());
			playerInput = null;
		}
		return playerInput;

	}

	private void markBoardCell(char mark, String playerInput) {
		board.markCell(mark, Integer.parseInt(playerInput.substring(0, 1)),
				Integer.parseInt(playerInput.substring(1)));

	}

	private void printResult(String winnerOrDraw) {
		board.print();
		System.out.println("Result: " + winnerOrDraw);
		System.out.println("Press Enter key to exit...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			inputReader.close();
		}

	}

}
