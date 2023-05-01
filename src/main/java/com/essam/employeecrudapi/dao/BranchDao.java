package com.essam.employeecrudapi.dao;

import java.util.List;

import com.essam.employeecrudapi.entity.Branch;

public interface BranchDao {
	
	void save(Branch branch);
	
	void update(Branch branch);
	
	List<Branch> findAll();
	
	Branch findById(Integer branchId);
	
	void deleteById(Integer id);
	

}
