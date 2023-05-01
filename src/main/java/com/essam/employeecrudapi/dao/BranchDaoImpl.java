package com.essam.employeecrudapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.essam.employeecrudapi.entity.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class BranchDaoImpl implements BranchDao {

	private final EntityManager entityManager;
	
	
	@Autowired
	public BranchDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Branch branch) {
		entityManager.persist(branch);
	}

	@Override
	@Transactional
	public void update(Branch branch) {
		entityManager.merge(branch);
	}

	@Override
	public List<Branch> findAll() {
		TypedQuery<Branch> query = entityManager.createQuery("from Branch", Branch.class);
		List<Branch> branchs = query.getResultList();
		return branchs;
	}

	@Override
	public Branch findById(Integer id) {
		TypedQuery<Branch> query = entityManager.createQuery("from Branch where id=:branchId", Branch.class);
		query.setParameter("branchId", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		Branch branch = this.findById(id);
		if(branch != null) {
			entityManager.remove(branch);
		}
	}

	

}
