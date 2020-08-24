package com.ait.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.binding.CaseWorkerManagementBind;

import com.ait.entity.CaseWorkerManagementEntity;
import com.ait.service.ICaseWorkerManagementService;
import com.ait.utility.MailSenderUtils;

@Controller
@RequestMapping(value = "/account")
public class CaseWorkerManagementController {

	@Autowired
	private ICaseWorkerManagementService service;

	@Autowired
	private MailSenderUtils mailUtils;

	@GetMapping(value = { "/home", "/login", "/" })
	public String registrationForm(Model model) {
		
		CaseWorkerManagementEntity entity = new CaseWorkerManagementEntity();
		model.addAttribute("caseWorkerManagementEntity", entity);
		return "caseWorkerManagementForm";

	}

	@PostMapping(value = "/create")
	public String saveCaseWorkerManagementData(@ModelAttribute CaseWorkerManagementBind bind,
			RedirectAttributes attributes, Model model) {
		Boolean isSave = false;
		attributes.addFlashAttribute("caseWorkerManagementEntity", new CaseWorkerManagementEntity());
		isSave = service.saveCaseWorkerManagement(bind);
		if (isSave) {
			//mailUtils.sendUserAccUnlockMail2(bind);
			attributes.addFlashAttribute("msg", "Account almost created.Check your email to unlock account");
		} else {
			attributes.addFlashAttribute("msg", "AccountCreationFaild");
		}

		return "redirect:/account/login";

	}

	@GetMapping(value = "/send")
	public void sendRedirect(@RequestParam("url") String url, HttpServletResponse res) throws IOException {

		res.sendRedirect(url);

	}
	
	@GetMapping("/all")
	public String retriveAllContacts(Model model) {
		List<CaseWorkerManagementBind> allAccounts = service.getAllAccount();
		model.addAttribute("allAccounts", allAccounts);
		
		CaseWorkerManagementBind account = new CaseWorkerManagementBind();
		model.addAttribute("account", account);
		 return "accountInfo";
		
	}
	
	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("cid")Integer contactId) {
		Boolean isDeleted = service.deleteAccountById(contactId);
		if(isDeleted) {
			return "redirect:/account/all";
		}
		return null;
		
	}
	
	@GetMapping("/edit")
	public String editAccount(@RequestParam("cid") Integer conId,Model model) {
		
		CaseWorkerManagementBind accountById = service.getAccountById(conId);
		model.addAttribute("caseWorkerManagementEntity", accountById);
		return "caseWorkerManagementForm";
		
	}

}
