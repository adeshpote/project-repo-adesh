package com.tictactoegame.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
	
	private BufferedReader br;

	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getUserInput(String messagePrompt) {
		String userInput = null;
		System.out.println(messagePrompt);
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInput;
	}

	public void close() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
