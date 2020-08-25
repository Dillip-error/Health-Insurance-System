package com.ait.service;

import java.util.List;

import com.ait.binding.PlanBinding;

public interface IPlanService {

	public Boolean savePlan(PlanBinding form);
	public List<PlanBinding>  getAllPlan();
	public PlanBinding   getPlanById(Integer id);
	public Boolean   deletePlanById(Integer id);
	
	public Integer updateStatusCode(Integer id);
}
