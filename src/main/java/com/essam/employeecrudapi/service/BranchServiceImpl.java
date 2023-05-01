package com.essam.employeecrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.essam.employeecrudapi.dao.BranchDao;
import com.essam.employeecrudapi.dao.EmployeeDao;
import com.essam.employeecrudapi.entity.Branch;


@Service
public class BranchServiceImpl implements BranchService {

	private final BranchDao branchDao;
	private final EmployeeDao employeeDao;
	
	@Autowired
	public BranchServiceImpl(BranchDao branchDao, EmployeeDao employeeDao) {
		this.branchDao = branchDao;
		this.employeeDao = employeeDao;
	}

	@Override
	public void save(Branch branch) {
		branchDao.save(branch);
	}

	@Override
	public void update(Branch branch) {
		branchDao.update(branch);
	}

	@Override
	public List<Branch> findAll() {
		return branchDao.findAll();
	}

	@Override
	public Branch findById(Integer id) {
		return branchDao.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		branchDao.deleteById(id);
	}

	@Override
	public boolean isEmpty(Integer branchId) {
		return employeeDao.getEmployeesByBranchId(branchId) == null;
	}
	
	

}
