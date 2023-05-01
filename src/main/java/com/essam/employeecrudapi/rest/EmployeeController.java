package com.essam.employeecrudapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.essam.employeecrudapi.entity.Employee;
import com.essam.employeecrudapi.rest.request.EmployeeBranchRequest;
import com.essam.employeecrudapi.service.EmployeeService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable Integer employeeId) {
		
		return employeeService.findById(employeeId);
	}
	
	@PostMapping()
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		employee.setId(null);
		employeeService.save(employee);
		return employee;
	}

	
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable Integer employeeId) {
		employeeService.deleteById(employeeId);
		return String.format("Employee with id %d has been deleted", employeeId);
	}
	
	@PutMapping()
	public Employee updateEmployee(@Valid @RequestBody Employee employee) {
		employeeService.update(employee);
		return employee;
	}
	
	@PutMapping("/employee-branch")
	public Employee addEmployeeToBranch(@Valid @RequestBody EmployeeBranchRequest request) {
		employeeService.addEmployeeToBranch(request);
		return employeeService.findById(request.getEmployeeId());
	}
}
