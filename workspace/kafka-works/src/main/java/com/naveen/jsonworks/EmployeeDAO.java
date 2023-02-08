package com.naveen.jsonworks;

// assume that you are connecting to database 
public class EmployeeDAO {

	public Employee getEmployee(int empId) {
		// we are mocking 
		if(empId ==100) {
			return new Employee(empId, "Sravani");
		}
		return null;
	}
	
	public Employee getEmployee(int empId, String name) {
		return new Employee(empId, name);
	}
	
}
