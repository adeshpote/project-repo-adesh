package com.techlabs2.input;

public class EmployeeDTO {
	private String empId;
	private String empName;
	private String empManagerId;
	
	public EmployeeDTO(String empId, String empName, String empManagerId){
		this.empId = empId;
		this.empName = empName;
		this.empManagerId = empManagerId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpManagerId() {
		return empManagerId;
	}

	public void setEmpManagerId(String empManagerId) {
		this.empManagerId = empManagerId;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName
				+ ", empManagerId=" + empManagerId;
	}
	
}
