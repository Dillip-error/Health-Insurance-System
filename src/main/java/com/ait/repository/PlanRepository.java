package com.ait.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ait.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE PLAN_TABLE set DELETE_STATUS='null' where PLAN_ID=?", nativeQuery = true)
	public Integer updateStatus(Integer PLAN_ID);

}
