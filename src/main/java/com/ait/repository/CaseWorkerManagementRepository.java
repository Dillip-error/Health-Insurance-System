package com.ait.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ait.entity.CaseWorkerManagementEntity;


public interface CaseWorkerManagementRepository extends JpaRepository<CaseWorkerManagementEntity, Serializable> {	
	
	public CaseWorkerManagementEntity findByPasswordAndEmail(String pazzword,String email);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE CASEWORKERMANAGEMENTENTITY set DELETE_STATUS='null' where REG_ID=?",nativeQuery=true)
	public Integer  updateStatus(Integer REG_ID);
	
	
	
}
