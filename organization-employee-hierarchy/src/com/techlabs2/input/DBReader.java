package com.techlabs2.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DBReader implements IEmployeeDataReader{

	@SuppressWarnings("resource")
	public List<EmployeeDTO> read() {
		List<EmployeeDTO> dtoList = new ArrayList<EmployeeDTO>();
		
		FileReader file = null;
		try{
			try{
				file = new FileReader("D:/swabhav techlabs/adesh/techlabs2/organization-employee-hierarchy/src/com/techlabs2/console/writer/EmployeeDetails.txt");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		BufferedReader br = new BufferedReader(file);
		String line = null;
		while ((line = br.readLine()) != null){
			String tokens[] = line.split("/");
			System.out.print(tokens[0]+" ");
			System.out.print(tokens[1]+" ");
			System.out.println(tokens[2]);
			System.out.println("");
			EmployeeDTO obj = new EmployeeDTO(tokens[0], tokens[1], tokens[2]);
			dtoList.add(obj);
		  }
		}catch(Exception ex){
			ex.getMessage();
		}
		return dtoList;
	}

}
