package com.techlabs2.console.writer;

import java.util.List;

import com.techlabs2.console.printer.SystemConsole;
import com.techlabs2.employee.details.Employee;
import com.techlabs2.input.DataSourceType;
import com.techlabs2.input.EmployeeDTO;
import com.techlabs2.input.IEmployeeDataReader;
import com.techlabs2.input.DataSourceTypeFactory;
import com.techlabs2.organization.Organization;

public class ConsoleWriterServiceImpl implements IConsoleWriterService {

	public void printToConsole(DataSourceType type) {
		IEmployeeDataReader reader = DataSourceTypeFactory.createFactory(type);
		List<EmployeeDTO> inputList = reader.read();
		
		Organization organization = new Organization(inputList);
		
		Employee ceo = organization.createHierarchy();
		SystemConsole printer = new SystemConsole();
		printer.printHierarchy(ceo);
	}

}
