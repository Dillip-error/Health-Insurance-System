package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ait.binding.PlanBinding;
import com.ait.entity.PlanEntity;
import com.ait.service.IPlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private IPlanService service;

	@GetMapping(value = { "/home", "/login", "/" })
	public String planForm(Model model) {

		PlanEntity entity = new PlanEntity();
		model.addAttribute("planEntity", entity);
		return "planForm";

	}

	@PostMapping(value = "/create")
	public String savePlanData(@ModelAttribute PlanBinding bind, RedirectAttributes attributes, Model model) {
		Boolean isSave = false;
		attributes.addFlashAttribute("planEntity", new PlanEntity());
		isSave = service.savePlan(bind);
		if (isSave) {
			attributes.addFlashAttribute("msg", "Your Plan Is Set..");
		} else {
			attributes.addFlashAttribute("msg", "Plan Creation Faild");
		}

		return "redirect:/plan/login";

	}

	@GetMapping("/all")
	public String retriveAllPlan(Model model) {
		List<PlanBinding> allPlan = service.getAllPlan();
		model.addAttribute("allPlans", allPlan);

		PlanEntity plan = new PlanEntity();
		model.addAttribute("planEntity", plan);
		return "planInfo";

	}

	@GetMapping("/delete")
	public String deletePlan(@RequestParam("pid") Integer pId) {
		Boolean isDeleted = service.deletePlanById(pId);
		if (isDeleted) {
			return "redirect:/plan/all";
		}
		return null;

	}

	@GetMapping("/edit")
	public String editPlan(@RequestParam("pid") Integer pId, Model model) {

		PlanBinding planById = service.getPlanById(pId);
		model.addAttribute("planEntity", planById);
		return "planForm";

	}
//
	@GetMapping("/active")
	public String editStatusForActive(@RequestParam("pid") Integer pId, Model model) {
		Integer updateStatusCode = service.updateStatusCode(pId);
		if (updateStatusCode <= 0) {
			return "redirect:/plan/all";
		} else {
			return "redirect:/plan/all";
		}
	}

}
