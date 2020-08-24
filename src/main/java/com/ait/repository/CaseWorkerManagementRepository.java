package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.CaseWorkerManagementEntity;

public interface CaseWorkerManagementRepository extends JpaRepository<CaseWorkerManagementEntity, Serializable> {	
	
	public CaseWorkerManagementEntity findByPasswordAndEmail(String pazzword,String email);
	
}
