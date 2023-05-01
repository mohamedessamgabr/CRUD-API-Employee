package com.essam.employeecrudapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.essam.employeecrudapi.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private final EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(Integer id) {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee where id=:employeeId", Employee.class);
		query.setParameter("employeeId", id);
		return query.getSingleResult();
	}

	@Override 
	@Transactional
	public void deleteById(Integer id) {
		Employee employee = this.findById(id);
		if (employee != null) {
			entityManager.remove(employee);
		}
	}

	
	@Override
	public List<Employee> getEmployeesByBranchId(Integer branchId) {
		TypedQuery<Employee> query = entityManager.createQuery("from Branch where id=:data", Employee.class);
		query.setParameter("data", branchId);
		return query.getResultList();
	}
}
