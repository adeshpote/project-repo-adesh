package com.techlabs2.console.printer;

import com.techlabs2.employee.details.Employee;

public class SystemConsole implements IConsole{

	public void printHierarchy(Employee ceo) {
		System.out.print(ceo.getName());
		for(Employee currentEmployee:ceo.getReporteeList()){
			System.out.println();
			System.out.print("  ");
			//System.out.print(currentEmployee.getName());
			printHierarchy(currentEmployee);
		}
	}

}
