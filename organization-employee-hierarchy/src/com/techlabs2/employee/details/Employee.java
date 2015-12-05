package com.techlabs2.employee.details;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String id;
	private String name;
	private String managerId;
	private List<Employee> reporteeList = new ArrayList<Employee>();
	
	public Employee(String id, String name, List<Employee>reporteeList){
		this.id = id;
		this.name = name;
		this.reporteeList = reporteeList;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getManagerId() {
		return managerId;
	}
	
	public List<Employee> getReporteeList() {
		return reporteeList;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	public void setReporteeList(List<Employee> reporteeList) {
		this.reporteeList=reporteeList;
	}
	
	public void addEmployee(Employee employee){
		reporteeList.add(employee);
	}
	
	public void removeEmployee(Employee employee){
		if(reporteeList.contains(employee)){
			reporteeList.remove(employee);
			System.out.println(employee+" is removed successfully..!");
		}
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", managerId="
				+ managerId+"]";
	}

}
