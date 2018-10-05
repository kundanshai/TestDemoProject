package com.simple.TestDemoProject.model.services;

import java.util.List;

import com.simple.TestDemoProject.model.EmployeeInfo;

public interface EmployeeService {
	
public void empSave(EmployeeInfo empInfo);

public List<EmployeeInfo> getEmployee(EmployeeInfo empInfo);

public List<EmployeeInfo> searchEmpInfo(EmployeeInfo empInfo);

public List<EmployeeInfo> getAllRecords();

public String update(Integer empId,EmployeeInfo employeeInfo);

default void m1() {
	
}
default void m12() {
	
}
public EmployeeInfo getEmpInfoId(Integer empId);
}
