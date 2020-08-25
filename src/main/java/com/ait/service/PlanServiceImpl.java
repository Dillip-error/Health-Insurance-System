package com.ait.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.binding.PlanBinding;
import com.ait.entity.PlanEntity;
import com.ait.repository.PlanRepository;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private PlanRepository repo;

	@Override
	public Boolean savePlan(PlanBinding form) {

		Boolean isSave = false;
		PlanEntity entity = new PlanEntity();
		BeanUtils.copyProperties(form, entity);
		repo.save(entity);
		isSave = true;
		return isSave;
	}

	@Override
	public List<PlanBinding> getAllPlan() {
		List<PlanBinding> planList = null;

		List<PlanEntity> findAllPlan = repo.findAll();

		planList = findAllPlan.stream().map(entity -> {
			PlanBinding bind = new PlanBinding();
			BeanUtils.copyProperties(entity, bind);
			return bind;
		}).collect(Collectors.toList());

		return planList;
	}

	@Override
	public PlanBinding getPlanById(Integer id) {
		PlanBinding bind = null;

		Optional<PlanEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			PlanEntity entity = findById.get();
			bind = new PlanBinding();
			BeanUtils.copyProperties(entity, bind);
			return bind;
		}
		return bind;
	}

	@Override
	public Boolean deletePlanById(Integer id) {
		Boolean isdelete = false;
		repo.deleteById(id);
		isdelete = true;
		return isdelete;

	}
	
	@Override
	public Integer updateStatusCode(Integer id) {
		Integer updateStatus = repo.updateStatus(id);
		return updateStatus;
	}
	
	

}
