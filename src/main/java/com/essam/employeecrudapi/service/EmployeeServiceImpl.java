package com.essam.employeecrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essam.employeecrudapi.dao.EmployeeDao;
import com.essam.employeecrudapi.entity.Branch;
import com.essam.employeecrudapi.entity.Employee;
import com.essam.employeecrudapi.rest.request.EmployeeBranchRequest;
import com.essam.employeecrudapi.util.AgeCalculatorFromID;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeDao;
	private final BranchService branchService;
	private final AgeCalculatorFromID ageCalculator;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao, BranchService branchService, AgeCalculatorFromID ageCalculator) {
		this.employeeDao = employeeDao;
		this.branchService = branchService;
		this.ageCalculator = ageCalculator;
	}

	@Override
	public void save(Employee employee) {
		Integer age = ageCalculator.getAge(employee.getNationalID());
		employee.setAge(age);
		employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		int age = ageCalculator.getAge(employee.getNationalID());
		if(employee.getBranch() == null) {
			Branch branch = this.findById(employee.getId()).getBranch();
			employee.setBranch(branch);
		}
		employee.setAge(age);
		employeeDao.update(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		return employeeDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		employeeDao.deleteById(id);
	}

	@Override
	public Employee addEmployeeToBranch(EmployeeBranchRequest request) {
		Employee employee = employeeDao.findById(request.getEmployeeId());
		Branch branch = branchService.findById(request.getBranchId());
		employee.setBranch(branch);
		employeeDao.update(employee);
		return employee;
	}

	

}
