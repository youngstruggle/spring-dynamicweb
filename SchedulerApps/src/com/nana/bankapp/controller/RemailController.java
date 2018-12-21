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

import com.nana.bankapp.model.Remail;
import com.nana.bankapp.services.RemailService;

@Controller
public class RemailController {

	@Autowired
	RemailService remailService;
	
	
	@RequestMapping("/newremail")
	public String newRcustomer(Model model) {
		System.out.println("masuk new remail");
		model.addAttribute("remail", new Remail());
		return "remail_add_form"; 
	}
	
	@RequestMapping(value = "/saveremail", method = RequestMethod.POST)
	public String saveRdivision(@Valid @ModelAttribute("remail") Remail remail, BindingResult result) {
		System.out.println("masuk add rdivision");
		if (result.hasErrors() ) {
			return "remail_add_form";
		} else {
			remailService.saveRemail(remail);
			return "redirect:/remail_list";
		}		
	} 
	
	@GetMapping("/remail_list")
	public String listRemail(Model model) {
		System.out.println("masuk list remail.");
		List<Remail> remail = remailService.getRemail();
		model.addAttribute("remail", remail);
		return "remail_list";
	}

	@GetMapping("/remailedit")
	public String updateRdivision(@RequestParam("email_id") String email_id, Model model) {
		System.out.println("masuk email edit");
		Remail remail =  remailService.getRemail(email_id);
		model.addAttribute("remail", remail);
		return "remail_add_form";
	}
	
	@GetMapping("/remaildelete")
	public String deleteDivision(@RequestParam("email_id") String email_id, Model model) {
		System.out.println("masuk email delete " + email_id + " ");
		remailService.deleteRemail(email_id);
		return "redirect:/remail_list";
	} 
	
}
