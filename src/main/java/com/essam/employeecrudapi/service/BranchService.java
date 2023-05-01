package com.essam.employeecrudapi.service;

import java.util.List;

import com.essam.employeecrudapi.entity.Branch;

public interface BranchService {
	
	void save(Branch branch);
	
	void update(Branch branch);
	
	List<Branch> findAll();
	
	Branch findById(Integer id);
	
	void deleteById(Integer id);
	
	boolean isEmpty(Integer branchId);

}
