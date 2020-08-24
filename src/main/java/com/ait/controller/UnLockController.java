package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.binding.CaseWorkerManagementBind;
import com.ait.binding.UnLockBind;
import com.ait.service.ICaseWorkerManagementService;

@Controller
public class UnLockController {

	@Autowired
	private ICaseWorkerManagementService service;

	@GetMapping("/finallogin")
	public String Login(@RequestParam("email") String mail, @RequestParam("OTP") String otp, Model model) {

		UnLockBind bind = new UnLockBind();
		model.addAttribute("mail", mail);
		model.addAttribute("otp", otp);
		model.addAttribute("unLockBind", bind);

		return "unlock";

	};

	@PostMapping("/read")
	public String readForm(@ModelAttribute("confirmPwd") UnLockBind bin, Model model) {
		UnLockBind bind = new UnLockBind();
		model.addAttribute("unLockBind", bind);
		try {

			CaseWorkerManagementBind accountDetailsBytempPwd = service.getAccountDetailsBytempPwd(bin.getTempPwd(),
					bin.getEmail());

			if (accountDetailsBytempPwd != null) {

				accountDetailsBytempPwd.setPassword(bin.getConfirmPwd());

				Boolean updateFormData = service.updateAccountData(accountDetailsBytempPwd);
				if (updateFormData != null) {
					return "confirm";
				}

			}
		} catch (Exception e) {

		}

		model.addAttribute("errorMsg", "Please Check Your  TempPassword");
		bind.setEmail(bin.getEmail());

		return "unlock";

	};

}
