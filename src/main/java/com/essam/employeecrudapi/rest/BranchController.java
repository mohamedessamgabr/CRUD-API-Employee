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

import com.essam.employeecrudapi.entity.Branch;
import com.essam.employeecrudapi.service.BranchService;


@RestController
@RequestMapping("/api/branches")
public class BranchController {
	
	private final BranchService branchService;
	
	
	@Autowired
	public BranchController(BranchService branchService) {
		this.branchService = branchService;
	}

	@GetMapping()
	public List<Branch> getAllBranches() {
		return branchService.findAll();
	}
	
	@GetMapping("/{branchId}")
	public Branch getBranchById(@PathVariable Integer branchId) {
		Branch branch = branchService.findById(branchId);
		return branch;
	}
	
	@PostMapping
	public Branch addBranch(@RequestBody Branch branch) {
		branch.setId(null);
		branchService.save(branch);
		return branch;
	}
	
	@PutMapping
	public Branch updateBranch(@RequestBody Branch branch) {
		branchService.update(branch);
		return branch;
	}
	
	@DeleteMapping("/{branchId}")
	public String deleteBranch(@PathVariable Integer branchId) {
		if(!branchService.isEmpty(branchId)) {
			throw new IllegalArgumentException(
					String.format("Branch with Id %d can not be deleted because it has employees", branchId));
		}
		branchService.deleteById(branchId);
		return String.format("Branch with id %d has been deleted", branchId);
	}
	
	

}
