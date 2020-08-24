package com.ait.service;

import java.util.List;

import com.ait.binding.CaseWorkerManagementBind;

public interface ICaseWorkerManagementService {
	
	public Boolean saveCaseWorkerManagement(CaseWorkerManagementBind form);
	public List<CaseWorkerManagementBind>  getAllAccount();
	public CaseWorkerManagementBind   getAccountById(Integer id);
	public Boolean   deleteAccountById(Integer id);
	
	public CaseWorkerManagementBind getAccountDetailsBytempPwd(String pazzword,String email);
	public Boolean updateAccountData(CaseWorkerManagementBind form);
	
	public Integer updateStatusCode(Integer id);

}
