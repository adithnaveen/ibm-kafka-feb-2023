package com.naveen.jsonworks;

// a java bean class is the one 
// which has private variable 
// public getters and setters 
// and a construction for usage 

public class Employee {
	private int empId; 
	private String empName;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public Employee() {}
	
	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	} 
	 
	
}
