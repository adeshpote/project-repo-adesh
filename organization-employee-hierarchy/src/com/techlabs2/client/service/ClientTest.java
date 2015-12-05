package com.techlabs2.client.service;

import com.techlabs2.console.writer.ConsoleWriterServiceImpl;
import com.techlabs2.input.DataSourceType;

public class ClientTest {

	public static void main(String[] args) {
		ConsoleWriterServiceImpl service = new ConsoleWriterServiceImpl();
		service.printToConsole(DataSourceType.FILEREADER);
	}
}
