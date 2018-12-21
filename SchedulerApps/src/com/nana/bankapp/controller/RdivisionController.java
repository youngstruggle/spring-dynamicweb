package com.nana.bankapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nana.bankapp.model.Rdivision;
import com.nana.bankapp.services.RdivisionService;

@Controller
public class RdivisionController {

	@Autowired
	RdivisionService rdivisionService;
	
	@RequestMapping("/newrdivision")
	public String newRcustomer(Model model) {
		System.out.println("masuk new rdivision");
		model.addAttribute("rdivision", new Rdivision());
		return "rdivision_add_form"; 
	}
	
	@RequestMapping(value = "/saverdivision", method = RequestMethod.POST)
	public String saveRdivision(@Valid @ModelAttribute("rdivision") Rdivision rdivision, BindingResult result) {
		System.out.println("masuk add rdivision");
		if (result.hasErrors() ) {
			return "rdivision_add_form";
		} else {
			rdivisionService.saveRdivision(rdivision);
			return "redirect:/rdivision_list";
		}		
	}
	
	@GetMapping("/rdivision_list")
	public String listRdivision(Model model) {
		System.out.println("masuk list rdivision");
		List<Rdivision> rdivision = rdivisionService.getRdivision();
		model.addAttribute("rdivision", rdivision);
		return "rdivision_list";
	}

	@GetMapping("/rdivisionedit")
	public String updateRdivision(@RequestParam("division_id") String division_id, Model model) {
		System.out.println("masuk division edit");
		Rdivision rdivision =  rdivisionService.getRdivision(division_id);
		model.addAttribute("rdivision", rdivision);
		return "rdivision_add_form";
	}
	
	@GetMapping("/rdivisiondelete")
	public String deleteDivision(@RequestParam("division_id") String division_id, Model model) {
		System.out.println("masuk division delete " + division_id);
		rdivisionService.deleteRdivision(division_id); 
		return "redirect:/rdivision_list";
	}
	
}
