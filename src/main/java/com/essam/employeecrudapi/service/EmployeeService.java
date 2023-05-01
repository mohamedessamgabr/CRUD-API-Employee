package com.essam.employeecrudapi.service;

import java.util.List;

import com.essam.employeecrudapi.entity.Employee;
import com.essam.employeecrudapi.rest.request.EmployeeBranchRequest;

public interface EmployeeService {

	void save(Employee employee);
	
	void update(Employee employee);
	
	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	void deleteById(Integer id);
	
	Employee addEmployeeToBranch(EmployeeBranchRequest request);
	
}
