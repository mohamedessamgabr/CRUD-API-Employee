package com.essam.employeecrudapi.dao;

import java.util.List;

import com.essam.employeecrudapi.entity.Employee;

public interface EmployeeDao {
	
	void save(Employee employee);
	
	void update(Employee employee);
	
	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	void deleteById(Integer id);
	
	List<Employee> getEmployeesByBranchId(Integer branchId);

}
