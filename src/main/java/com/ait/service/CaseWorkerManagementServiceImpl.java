package com.ait.service;

import static com.ait.constant.AppConstants.finallockedStatus;
import static com.ait.constant.AppConstants.lockedStatus;
import static com.ait.constant.AppConstants.size;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.binding.CaseWorkerManagementBind;
import com.ait.entity.CaseWorkerManagementEntity;
import com.ait.repository.CaseWorkerManagementRepository;
import com.ait.utility.PwdUtility;

@Service
public class CaseWorkerManagementServiceImpl implements ICaseWorkerManagementService {

	@Autowired
	private CaseWorkerManagementRepository repo;

	@Override
	public Boolean saveCaseWorkerManagement(CaseWorkerManagementBind form) {
		Boolean isSave = false;
		form.setPassword(PwdUtility.randomPwdGen(size));
		form.setAccStatus(lockedStatus);
		CaseWorkerManagementEntity entity = new CaseWorkerManagementEntity();
		BeanUtils.copyProperties(form, entity);
		repo.save(entity);
		isSave = true;
		return isSave;
	}

	@Override
	public List<CaseWorkerManagementBind> getAllAccount() {
		List<CaseWorkerManagementBind> accountList = null;

		List<CaseWorkerManagementEntity> findAllAccount = repo.findAll();

		accountList = findAllAccount.stream().map(entity -> {
			CaseWorkerManagementBind bind = new CaseWorkerManagementBind();
			BeanUtils.copyProperties(entity, bind);
			return bind;
		}).collect(Collectors.toList());

		return accountList;
	}

	@Override
	public CaseWorkerManagementBind getAccountById(Integer id) {
		CaseWorkerManagementBind bind = null;

		Optional<CaseWorkerManagementEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			CaseWorkerManagementEntity entity = findById.get();
			bind = new CaseWorkerManagementBind();
			BeanUtils.copyProperties(entity, bind);
			return bind;
		}

		return null;
	}

	@Override
	public Boolean deleteAccountById(Integer id) {
		Boolean isdelete = false;
		repo.deleteById(id);
		isdelete = true;
		return isdelete;
	}

	@Override
	public CaseWorkerManagementBind getAccountDetailsBytempPwd(String pazzword, String email) {
		CaseWorkerManagementEntity findByPassword = repo.findByPasswordAndEmail(pazzword,email);
		CaseWorkerManagementBind form = null;
		
		if(findByPassword != null) {
			form = new CaseWorkerManagementBind();
			BeanUtils.copyProperties(findByPassword,form);
		}
		
		return form;
	}

	@Override
	public Boolean updateAccountData(CaseWorkerManagementBind form) {
		Boolean isUpdate = false;
		form.setAccStatus(finallockedStatus);
		CaseWorkerManagementEntity entity = new CaseWorkerManagementEntity();
		BeanUtils.copyProperties(form,entity);
		repo.save(entity);
		isUpdate = true;
		return isUpdate;
	}

	@Override
	public Integer updateStatusCode(Integer id) {
		Integer updateStatus = repo.updateStatus(id);
		return updateStatus;
	}

}
