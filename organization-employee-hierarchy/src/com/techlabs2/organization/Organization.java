package com.techlabs2.organization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techlabs2.employee.details.Employee;
import com.techlabs2.input.EmployeeDTO;

public class Organization {
	private Map<String, Employee> employeeMap = new HashMap<String, Employee>();
	private List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
	
	//constructor
	public Organization(List<EmployeeDTO> inputList){
		this.employeeList = inputList;
	}
	
	//method
	public Employee createHierarchy(){
		Employee ceo;
		
		//List<Employee> dummyList = new ArrayList<Employee>();
		
		
		for(EmployeeDTO currentEmployee:employeeList){
			
			List<Employee> reporteeList = new ArrayList<Employee>();
			Employee employee = new Employee(currentEmployee.getEmpId(), currentEmployee.getEmpName(), reporteeList);
			employee.setManagerId(currentEmployee.getEmpManagerId());
			//System.out.println(employeeMap);
			
			if(!employeeMap.containsKey(employee.getId())){
				employeeMap.put(employee.getId(), employee);
			}else if(employeeMap.containsKey(employee.getId())){
				List<Employee> dummyList = employeeMap.get(employee.getId()).getReporteeList();
				
				for(Employee reportee:dummyList){
					employee.addEmployee(reportee);
				}
				
				employeeMap.get(employee.getId()).setManagerId(employee.getManagerId());
				employeeMap.get(employee.getId()).setName(employee.getName());
			}
			
				if(employeeMap.containsKey(employee.getManagerId())){
					employeeMap.get(employee.getManagerId()).addEmployee(employee);
					/*Employee manager = employeeMap.get(employee.getManagerId());
					manager.addEmployee(employee);
					reporteeList = manager.getReporteeList();
					System.out.println(reporteeList);*/
				}else{
					List<Employee> demoList = new ArrayList<Employee>();
					Employee demoEmployee = new Employee(employee.getManagerId(), "", demoList);
					demoEmployee.addEmployee(employee);
					employeeMap.put(demoEmployee.getId(), demoEmployee);
			}
		}
		ceo = employeeMap.get("01");
		return ceo;
	}
}
		
		/*for(Map.Entry<String, Employee> currentEmployee:employeeMap.entrySet()){
			for(Employee emp:dummyList){
				if(employeeMap.containsKey(employee.getId()) == dummyList.contains(employee.getManagerId())){
					String manager = currentEmployee.getValue().getId();
					String reportee = emp.getManagerId();
					employee.setId(manager);
					employee.setManagerId(reportee);
					
					reporteeList.add(employee);
					System.out.println(reporteeList);
				}
			}
		}*/
		
/*Employee employee = new Employee(currentEmployee.getEmpId(), currentEmployee.getEmpName(), reporteeList);
employee.setManagerId(currentEmployee.getEmpManagerId());

//to check whether new employee is added.
if(!(employeeMap.containsKey(currentEmployee.getEmpManagerId()))){
	employeeMap.put(employee.getId(), employee);
}else{
	if((employee.getManagerId()).isEmpty()){
		Employee ceo = new Employee(employee.getId(), employee.getName(), reporteeList);
	}
	System.out.println("Employee with "+currentEmployee.getEmpId()+" is already present");
	(employeeMap.get(employee.getId())).setManagerId(employee.getManagerId());
	(employeeMap.get(employee.getId())).setName(employee.getName());
	if((employeeMap.get(employee.getId())).equals(employee.getManagerId())){
		Employee manager = employeeMap.get(employee.getManagerId());
		manager.addEmployee(employee);
		reporteeList = manager.getReporteeList();
		System.out.println(reporteeList);
	}
}*/
